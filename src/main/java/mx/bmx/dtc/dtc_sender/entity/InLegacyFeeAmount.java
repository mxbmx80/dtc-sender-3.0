package mx.bmx.dtc.dtc_sender.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Информация о сумме и валюте
 *  currencyId Валюта.
 *  value      Сумма.
 *  feeKbo     КБО комиссии.
 * */
@Builder
@Data
@AllArgsConstructor
public class InLegacyFeeAmount {
    private String currencyId;

    private BigDecimal value;

    private String feeKbo;
}
