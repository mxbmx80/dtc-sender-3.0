package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * Сумма операции
 *
 * @param currencyId - Идентификатор валюты
 * @param value - Сумма
 */
public record Amount(@Size(max = 10) String currencyId, @Size(max = 30) BigDecimal value) {

}
