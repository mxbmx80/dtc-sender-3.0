package mx.bmx.dtc.dtc_sender.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Блок с данными по legacy-операциям.
 * debit  Информация о счете списания.
 * credit Информация о счете зачисления.
 * */
@Builder
@Data
@AllArgsConstructor
public class InLegacyTransactionData {
    private InLegacyTransaction debit;

    private InLegacyTransaction credit;
}
