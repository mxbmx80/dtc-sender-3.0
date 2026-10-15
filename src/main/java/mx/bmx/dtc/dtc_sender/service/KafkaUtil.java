package mx.bmx.dtc.dtc_sender.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;
import ru.vtb.msa.mdclogging.formatter.KafkaMessageLogFormatter;
import ru.vtb.msa.mdclogging.mdc.MdcService;
import ru.vtb.msa.mdclogging.mqserver.kafka.SpringKafkaConsumerExtensionsKt;
import ru.vtb.msa.savings.deposit.common.masking.formatters.CustomKafkaMessageLogFormatter;
import ru.vtb.msa.savings.deposit.common.masking.systems.IntegrationSystemId;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class KafkaUtil {
    private final MdcService mdcService;
    private final CustomKafkaMessageLogFormatter kafkaMessageLogFormatter;

    /**
     * Метод создания базовой consumer factory с десериализацией на основе класса String
     * @param kafkaProperties свойства подключения к Kafka
     * @param integrationName название интеграции
     * @return базовая consumer factory с десериализацией на основе класса String и кастомным логированием
     */
    public ConsumerFactory<String, String> getStringConsumerFactory(final KafkaProperties kafkaProperties, IntegrationSystemId integrationName) {
        final Map<String, Object> consumerProperties = kafkaProperties
                .buildConsumerProperties();
        consumerProperties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        final ConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(
                consumerProperties, new StringDeserializer(), new StringDeserializer()
        );

        final var kafkaLogFormatter = getKafkaLogFormatter(integrationName);
        SpringKafkaConsumerExtensionsKt.withMdcLogging(consumerFactory, kafkaLogFormatter, mdcService);
        return consumerFactory;
    }

    public KafkaMessageLogFormatter getKafkaLogFormatter(IntegrationSystemId integrationName) {
        return kafkaMessageLogFormatter.withRemoteSystem(integrationName);
    }
}
