package mx.bmx.dtc.dtc_sender.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;

@Getter
@Setter
@ConfigurationProperties("dtc.connector")
@AllArgsConstructor
public class DtcConnectorProperties {
    private Boolean enabled; //Вкл/откл коннектора (если false бин DtcConnector создан не будет)
    private String requestTopic; // Топик кафки для отправки запросов
    @NestedConfigurationProperty
    private KafkaProperties kafka; // Настройки серверов брокеров кафки
}
