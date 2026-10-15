package mx.bmx.dtc.dtc_sender.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.bmx.dtc.dtc_sender.config.DtcConnectorProperties;
import mx.bmx.dtc.dtc_sender.service.TransactionIdGenerator;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.vtb.dtc.api.input.InHeader;
import ru.vtb.dtc.api.input.InMessage;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Slf4j
@Service
@RequiredArgsConstructor
public class SenderService {

    private final TransactionIdGenerator transactionIdGenerator;
    private final KafkaTemplate<String, InMessage> kafkaTemplate;
    private final DtcConnectorProperties properties;

    public String sendMessage(String xCallId, String xMessageId, String replyTopic, InMessage inMessage) {
        var transactionId =  transactionIdGenerator.generate("TRN", "B", "TRNB", Clock.systemDefaultZone(), null);
        InHeader inHeader = new InHeader(transactionId, inMessage.getHeader().getScenarioId(), inMessage.getHeader().getInitiator(), inMessage.getHeader().getSentToDtcTime());


        InMessage inMessage1 = new InMessage(inMessage.getTechInfo(), inHeader, inMessage.getTransactionInfo(),
                inMessage.getTransactionData(), inMessage.getLegacyTransactionData(),
                inMessage.getAdjustedTransactions(),
                inMessage.getAdditionalInfo());

        var requestBuilder = MessageBuilder
                .withPayload(inMessage1)
                .setHeader("X-Call-ID", xCallId)
                .setHeader("X-Message-ID", xMessageId)
                .setHeader("replyTopic", replyTopic)
                .setHeader(KafkaHeaders.TOPIC, properties.getRequestTopic());
        var request = requestBuilder.build();

        Instant dateTime = request.getPayload().getHeader().getSentToDtcTime().atZone(ZoneId.systemDefault()).toInstant();
        Instant dateTime1 = request.getPayload().getHeader().getSentToDtcTime().toInstant(ZoneOffset.UTC);

        kafkaTemplate.send(request).thenAccept(response -> log.debug("Message successfully sent at offset - {}", response.getRecordMetadata().offset()));


        return transactionId;
    }
}
