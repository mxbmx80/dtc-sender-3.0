package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * Информация о заголовках.
 *
 * @param transactionId    Идентификатор транзакции в DTC.
 * @param initiator        Информация об инициаторе.
 * @param scenarioId       Идентификатор сценария.
 * @param sentToDtcTime    Время отправки операции в DTC.
 */
@Builder
public record InHeader(@Size(max = 25) String transactionId, @Size(max = 50) String scenarioId, InInitiator initiator,
                       LocalDateTime sentToDtcTime) {

}
