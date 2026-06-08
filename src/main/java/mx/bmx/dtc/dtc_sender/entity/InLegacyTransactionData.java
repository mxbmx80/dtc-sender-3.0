package mx.bmx.dtc.dtc_sender.entity;

import lombok.Builder;

/**
 * Блок с данными по legacy-операциям.
 * @param debit  Информация о счете списания.
 * @param credit Информация о счете зачисления.
 * */
public record InLegacyTransactionData (InLegacyTransaction debit, InLegacyTransaction credit) {

}
