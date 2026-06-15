package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Банк\Клиент корреспондент.
 *  accountNumber  Номер корреспондентского счёта.
 *  bankName       Наименование банка\клиента.
 *  address        Адрес банка.
 *  bic            БИК корреспондена
 * */
@Builder
@Data
@AllArgsConstructor
public class InLegacyCorrespondentBankcorrespondentBank {
    @Size(max = 100)
    private String accountNumber;

    @Size(max = 250)
    private String bankName;

    @Size(max = 250)
    private String address;

    private String country;

    @Size(max = 12)
    private String bic;
}
