package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;

/**
 * Информация об операторе.
 * @param operatorId    Идентификатора оператора.
 */
public record InOperatorInfo(@Size(max = 50) String operatorId) {
}
