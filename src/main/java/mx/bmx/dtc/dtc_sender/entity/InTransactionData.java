package mx.bmx.dtc.dtc_sender.entity;

import java.util.List;

/**
 * Финансовая транзакция.
 * @param debit      Информация о счетах списания.
 * @param credit     Информация о счетах поступления.
 */
public record InTransactionData(List<InOperation> debit, List<InOperation> credit) {

}
