package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;

/**
 * Банк\Клиент корреспондент.
 * @param accountNumber  Номер корреспондентского счёта.
 * @param bankName       Наименование банка\клиента.
 * @param address        Адрес банка.
 * @param bic            БИК корреспондена
 * */
public record InLegacyCorrespondentBankcorrespondentBank (@Size(max = 100) String accountNumber, @Size(max = 250) String bankName, @Size(max = 250) String address,
                                                          String country, @Size(max = 12) String bic ) {
}
