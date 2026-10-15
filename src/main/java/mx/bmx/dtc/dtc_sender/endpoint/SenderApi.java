package mx.bmx.dtc.dtc_sender.endpoint;

import jakarta.validation.Valid;
import mx.bmx.dtc.dtc_sender.dto.EmptyResponseData;
import mx.bmx.dtc.dtc_sender.dto.ResponseMessage;
import ru.vtb.dtc.api.input.InMessage;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping(value = "/v1")
public interface SenderApi {
    @PostMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMessage<EmptyResponseData> sendMessageToDTC(@RequestHeader(value = "X-Call-ID") String xCallId,
                                                        @RequestHeader(value = "X-Message-ID") String xMessageId,
                                                        @RequestHeader(value = "replyTopic") String replyTopic,
                                                     @RequestBody @Valid InMessage inMessage) throws Exception;
}
