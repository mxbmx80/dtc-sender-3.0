package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Сумма операции
 *
 * currencyId - Идентификатор валюты
 * value - Сумма
 */
@Builder
@Data
@AllArgsConstructor
public class Amount {
    @Size(max = 10)
    private String currencyId;

    @Size(max = 30)
    private BigDecimal value;
}
