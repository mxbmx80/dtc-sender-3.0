package mx.bmx.dtc.dtc_sender.entity;

import lombok.Builder;

/**
 * Блок с данными по legacy-операциям.
 * <p>
 * Содержит информацию о транзакции, включая счет, сумму, комиссии и порядок выполнения.
 * </p>
 *
 * @param typeExecutionOrder Очередность выполнения операции по данной стороне транзакции.
 * @param account            Информация о счете, карте, депозитном договоре или ином объекте списания.
 * @param amount             Информация о сумме и валюте.
 * @param clientFee          Информация о сумме и валюте комиссии.
 * @param loanFee            Информация о комиссии за использование кредитных средств
 * @param typeExecutionOrder Очередность выполнения операции по данной стороне транзакции.
 */
public record InLegacyTransaction(int typeExecutionOrder, InLegacyAccount account, InLegacyAmount amount, InLegacyFeeAmount clientFee, InLegacyFeeAmount loanFee) {

}