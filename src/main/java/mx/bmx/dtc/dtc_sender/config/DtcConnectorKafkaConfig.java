package mx.bmx.dtc.dtc_sender.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import mx.bmx.dtc.dtc_sender.service.KafkaUtil;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import ru.vtb.dtc.api.input.InMessage;
import ru.vtb.dtc.api.output.OutMessage;
import ru.vtb.msa.mdclogging.mdc.MdcService;
import ru.vtb.msa.mdclogging.mqserver.kafka.SpringKafkaConsumerExtensionsKt;
import ru.vtb.msa.savings.deposit.common.masking.enums.ExternalIntegrationSystems;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ru.vtb.msa.mdclogging.mqclient.kafka.SpringKafkaProducerExtensionsKt.withMdcLogging;

@Configuration
@ConditionalOnProperty(value = "dtc.connector.enabled", havingValue = "true")
@EnableConfigurationProperties(DtcConnectorProperties.class)
@RequiredArgsConstructor
public class DtcConnectorKafkaConfig {
    private final MdcService mdcService;
    private final ObjectMapper objectMapper;
    private final KafkaUtil kafkaUtil;

    @Bean
    public KafkaTemplate<String, InMessage> dtcConnectorRequestKafkaTemplate(ProducerFactory<String, InMessage> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public ProducerFactory<String, InMessage> dtcConnectorRequestProducerFactory(DtcConnectorProperties properties) throws IOException {
        var factory = new DefaultKafkaProducerFactory<String, InMessage>(producerConfigs(properties));
        final var keySerializer = new StringSerializer();
        final var valueSerializer = new JsonSerializer<InMessage>(objectMapper);
        factory.setKeySerializer(keySerializer);
        factory.setValueSerializer(valueSerializer);
        withMdcLogging(factory, kafkaUtil.getKafkaLogFormatter(ExternalIntegrationSystems.DTC.getId()), mdcService);

        return factory;
    }

    private Map<String, Object> producerConfigs(DtcConnectorProperties properties) throws IOException {
        final var props  = new HashMap<String, Object>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getKafka().getBootstrapServers());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        addSsl(props, properties.getKafka());

        return props;
    }


    @Bean
    public ConsumerFactory<String, OutMessage> dtcConnectorConsumerFactory(DtcConnectorProperties properties) throws IOException {
        final var factory = new DefaultKafkaConsumerFactory<String, OutMessage>(consumerConfigs(properties));
        factory.setValueDeserializer(new JsonDeserializer<>(OutMessage.class));
        SpringKafkaConsumerExtensionsKt.withMdcLogging(factory, kafkaUtil.getKafkaLogFormatter(ExternalIntegrationSystems.DTC.getId()), mdcService);
        return factory;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, OutMessage>>
    dtcConnectorListenerContainerFactory(ConsumerFactory<String, OutMessage>dtcConnectorConsumerFactory, DtcConnectorProperties props) {
        final var factory = new CommonConcurrentKafkaListenerContainerFactory<String, OutMessage>();
        factory.setConsumerFactory(dtcConnectorConsumerFactory);
        factory.setConcurrency(props.getConcurrency());
        return factory;
    }

    private Map<String, Object> consumerConfigs(DtcConnectorProperties properties) throws IOException {
        final var props = new HashMap<String, Object>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getKafka().getBootstrapServers());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, properties.getKafka().getConsumer().getGroupId());

        addSsl(props, properties.getKafka());

        return props;
    }

    private void addSsl(HashMap<String, Object> config, KafkaProperties properties) throws IOException {
        if (properties.getSecurity().getProtocol() != null && !properties.getSecurity().getProtocol().isEmpty()) {
            config.put("security.protocol", properties.getSecurity().getProtocol());
        }

        if (properties.getSecurity().getProtocol().equals("PLAINTEXT")) return;

        var sslConfig = properties.getSsl();

        if (sslConfig.getTrustStoreLocation() != null) {
            config.put("ssl.truststore.location", sslConfig.getTrustStoreLocation().getFile().getAbsolutePath());
        }
        if (sslConfig.getTrustStorePassword() != null && !sslConfig.getTrustStorePassword().isEmpty()) {
            config.put("ssl.truststore.password", sslConfig.getTrustStorePassword());
        }
        if (sslConfig.getTrustStoreType() != null && !sslConfig.getTrustStoreType().isEmpty()) {
            config.put("ssl.truststore.type", sslConfig.getTrustStoreType());
        }

        if (sslConfig.getKeyStoreLocation().exists()) {
            config.put("ssl.keystore.location", sslConfig.getKeyStoreLocation().getFile().getAbsolutePath());
        }
        if (sslConfig.getKeyStorePassword() != null && !sslConfig.getKeyStorePassword().isEmpty()) {
            config.put("ssl.keystore.password", sslConfig.getKeyStorePassword());
        }
        if (sslConfig.getKeyStoreType() != null && !sslConfig.getKeyStoreType().isEmpty()) {
            config.put("ssl.keystore.type", sslConfig.getKeyStoreType());
        }
        if (sslConfig.getKeyPassword() != null && !sslConfig.getKeyPassword().isEmpty()) {
            config.put("ssl.key.password", sslConfig.getKeyPassword());
        }
    }
}
