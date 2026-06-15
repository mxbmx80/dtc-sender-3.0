package mx.bmx.dtc.dtc_sender.config;

import lombok.RequiredArgsConstructor;
import mx.bmx.dtc.dtc_sender.entity.InMessage;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


import java.io.IOException;

@Configuration
@ConditionalOnProperty(value = "dtc.connector.enabled", havingValue = "true")
@EnableConfigurationProperties(DtcConnectorProperties.class)
@RequiredArgsConstructor
public class DtcConnectorKafkaConfig {

    @Bean
    public KafkaTemplate<String, InMessage> dtcConnectorRequestKafkaTemplate(ProducerFactory<String, InMessage> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public ProducerFactory<String, InMessage> dtcConnectorRequestProducerFactory(DtcConnectorProperties properties) {
        return new DefaultKafkaProducerFactory<>(properties.getKafka().buildProducerProperties());
    }


}
