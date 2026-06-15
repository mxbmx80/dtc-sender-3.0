package mx.bmx.dtc.dtc_sender.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Блок с данными по legacy-операциям.
 * <p>
 * Содержит информацию о транзакции, включая счет, сумму, комиссии и порядок выполнения.
 * </p>
 *
 *  typeExecutionOrder Очередность выполнения операции по данной стороне транзакции.
 *  account            Информация о счете, карте, депозитном договоре или ином объекте списания.
 *  amount             Информация о сумме и валюте.
 *  clientFee          Информация о сумме и валюте комиссии.
 *  loanFee            Информация о комиссии за использование кредитных средств
 *  typeExecutionOrder Очередность выполнения операции по данной стороне транзакции.
 */
@Builder
@Data
@AllArgsConstructor
public class InLegacyTransaction {
    private int typeExecutionOrder;

    private InLegacyAccount account;

    private InLegacyAmount amount;

    private InLegacyFeeAmount clientFee;

    private InLegacyFeeAmount loanFee;
}