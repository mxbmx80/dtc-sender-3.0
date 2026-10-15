package mx.bmx.dtc.dtc_sender.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.vtb.dtc.api.output.OutMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaDtc30Receiver {
    @KafkaListener(
            id = "dtcConnectorListener",
            topics = "${dtc.connector.response-topic}",
            containerFactory = "dtcConnectorListenerContainerFactory",
            autoStartup = "${dtc.connector.consumer-enabled}"
    )
    public void consumeMessage(@Payload OutMessage message, ConsumerRecord<String, OutMessage> record) {
        try {
            log.info("Get response from dtc 3.0 for operation: {}. Offset: {}, partition: {}", message.getHeader().getTransactionId(), record.offset(), record.partition());
        } catch (Throwable ex) {
            log.error("Error by processing request", ex);
        }
    }
}
