package mx.bmx.dtc.dtc_sender.entity;

import java.math.BigDecimal;

/**
 * Информация о сумме и валюте
 * @property currencyId Валюта.
 * @property value      Сумма.
 * @property feeKbo     КБО комиссии.
 * */
public record InLegacyFeeAmount(String currencyId, BigDecimal value, String feeKbo) {

}
