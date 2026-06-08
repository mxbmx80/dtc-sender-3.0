package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * Информация о сумме и валюте
 * @property currencyId Валюта.
 * @property value      Сумма.
 * */
public record InLegacyAmount(@Size(max = 10) String currencyId, @Size(max = 30) BigDecimal value) {

}
