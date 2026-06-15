package mx.bmx.dtc.dtc_sender.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.bmx.dtc.dtc_sender.config.DtcConnectorProperties;
import mx.bmx.dtc.dtc_sender.entity.InMessage;
import mx.bmx.dtc.dtc_sender.service.TransactionIdGenerator;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.Clock;

@Slf4j
@Service
@RequiredArgsConstructor
public class SenderService {

    private final TransactionIdGenerator transactionIdGenerator;
    private final KafkaTemplate<String, InMessage> kafkaTemplate;
    private final DtcConnectorProperties properties;

    public String sendMessage(String xCallId, InMessage inMessage) {
        var transactionId =  transactionIdGenerator.generate("TRN", "B", "TRNB", Clock.systemDefaultZone(), null);
        inMessage.getHeader().setTransactionId(transactionId);

        var requestBuilder = MessageBuilder
                .withPayload(inMessage)
                .setHeader("x-call-id", xCallId)
                .setHeader(KafkaHeaders.TOPIC, properties.getRequestTopic());
        var request = requestBuilder.build();

        kafkaTemplate.send(request).thenAccept(response -> log.debug("Message successfully sent at offset - {}", response.getRecordMetadata().offset()));;


        return transactionId;
    }
}
