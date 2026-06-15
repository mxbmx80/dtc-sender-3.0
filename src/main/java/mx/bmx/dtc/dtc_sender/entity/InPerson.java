package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

/**
 * Информация о физ/юр лице
 *  mdmId                   Идентификатор Клиента в МДМ.
 *  branch                  Код филиала счета.
 *  taxId                   ИНН.
 *  kpp                     КПП.
 *  name                    Информация об имени.
 *  orgName                 Наименование организации.
 *  orgOfficialName         Полное наименование организации (по Уставу).
 *  partyIdentification     Филиал.
 *  paymentSystemCode       Код платежной системы.
 *  transitAccountNumber    Номер транзитного счета.
 *  transitMemberId         Идентификатор транзита.
 *  treasuryReference       Справка.
 *  address                 Адрес.
 *  phone                   Номер телефона.
 *  clientType              Тип клиента.
 *  clientSystem            Система клиента
 * */
@Builder
@Data
@AllArgsConstructor
public class InPerson {
    @Size(max = 50)
    private String mdmId;

    private String branch;

    @Size(max = 12)
    private String taxId;

    @Size(max = 9)
    private String kpp;

    private ClientType clientType;

    private String clientSystem;

    private InName name;

    @Size(max = 250)
    private String orgName;

    @Size(max = 250)
    private String orgOfficialName;

    private InPartyIdentification partyIdentification;

    @Size(max = 50)
    private String paymentSystemCode;

    @Size(max = 30)
    private String transitAccountNumber;

    @Size(max = 30)
    private String transitMemberId;

    @Size(max = 100)
    private String treasuryReference;

    private InAddress address;

    @Size(max = 16)
    private String phone;
}

