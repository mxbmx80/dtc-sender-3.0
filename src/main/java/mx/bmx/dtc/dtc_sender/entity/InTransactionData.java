package mx.bmx.dtc.dtc_sender.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Финансовая транзакция.
 * debit      Информация о счетах списания.
 * credit     Информация о счетах поступления.
 */
@Data
@Builder
@AllArgsConstructor
public class InTransactionData {
    private List<InOperation> debit;
    private List<InOperation> credit;
}
