package mx.bmx.dtc.dtc_sender.controller;

import lombok.RequiredArgsConstructor;
import mx.bmx.dtc.dtc_sender.dto.EmptyResponseData;
import mx.bmx.dtc.dtc_sender.dto.ResponseMessage;
import mx.bmx.dtc.dtc_sender.endpoint.SenderApi;
import mx.bmx.dtc.dtc_sender.entity.InMessage;
import mx.bmx.dtc.dtc_sender.service.impl.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller implements SenderApi {
    private final SenderService senderService;

    @Override
    public ResponseMessage<EmptyResponseData> sendMessageToDTC(String xCallId, InMessage inMessage) throws Exception {
        String sessionId = senderService.sendMessage(xCallId, inMessage);

        return ResponseMessage.of(true, sessionId, new EmptyResponseData());
    }
}
