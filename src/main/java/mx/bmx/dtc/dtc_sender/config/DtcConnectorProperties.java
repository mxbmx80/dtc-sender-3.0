package mx.bmx.dtc.dtc_sender.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

@Getter
@Setter
@ConfigurationProperties("dtc.connector")
@AllArgsConstructor
public class DtcConnectorProperties {
    private Boolean enabled; //Вкл/откл коннектора (если false бин DtcConnector создан не будет)
    private String requestTopic; // Топик кафки для отправки запросов
    private String responseTopic; // Топик кафки для получения ответов
    private Boolean consumerEnabled; // Вкл/откл консьюмера ответов от координатора
    private Integer concurrency; // Уровень параллелизма (по умолчанию 1)
    @NestedConfigurationProperty
    private KafkaProperties kafka; // Настройки серверов брокеров кафки
}
