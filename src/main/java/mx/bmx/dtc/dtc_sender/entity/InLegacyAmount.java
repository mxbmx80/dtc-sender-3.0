package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Информация о сумме и валюте
 * currencyId Валюта.
 * value      Сумма.
 * */
@Builder
@Data
@AllArgsConstructor
public class InLegacyAmount {
    @Size(max = 10)
    private String currencyId;

    @Size(max = 30)
    private BigDecimal value;

}
