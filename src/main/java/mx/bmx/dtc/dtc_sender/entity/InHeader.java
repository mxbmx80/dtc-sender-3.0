package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Информация о заголовках.
 *  transactionId    Идентификатор транзакции в DTC.
 *  initiator        Информация об инициаторе.
 *  scenarioId       Идентификатор сценария.
 *  sentToDtcTime    Время отправки операции в DTC.
 */
@Builder
@Data
@AllArgsConstructor
public class InHeader {
    @Size(max = 25)
    private String transactionId;

    @Size(max = 50)
    private String scenarioId;

    private InInitiator initiator;

    private LocalDateTime sentToDtcTime;
}
