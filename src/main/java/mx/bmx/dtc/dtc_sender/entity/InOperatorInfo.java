package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Информация об операторе.
 * Идентификатора оператора
 */
@Builder
@Data
@AllArgsConstructor
public class InOperatorInfo {
    @Size(max = 50)
    String operatorId;
}
