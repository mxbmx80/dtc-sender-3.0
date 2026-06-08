package mx.bmx.dtc.dtc_sender.service.impl;

import lombok.RequiredArgsConstructor;
import mx.bmx.dtc.dtc_sender.entity.InMessage;
import mx.bmx.dtc.dtc_sender.service.TransactionIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Clock;

@Service
@RequiredArgsConstructor
public class SenderService {

    private final TransactionIdGenerator transactionIdGenerator;

    public String sendMessage(String xCallId, InMessage inMessage) {
        return transactionIdGenerator.generate("TRN", "B", "TRNB", Clock.systemDefaultZone(), null);
    }
}
