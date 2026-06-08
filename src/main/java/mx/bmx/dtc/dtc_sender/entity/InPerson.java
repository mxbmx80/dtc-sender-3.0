package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.Objects;

/**
 * Информация о физ/юр лице
 * @param mdmId                   Идентификатор Клиента в МДМ.
 * @param branch                  Код филиала счета.
 * @param taxId                   ИНН.
 * @param kpp                     КПП.
 * @param name                    Информация об имени.
 * @param orgName                 Наименование организации.
 * @param orgOfficialName         Полное наименование организации (по Уставу).
 * @param partyIdentification     Филиал.
 * @param paymentSystemCode       Код платежной системы.
 * @param transitAccountNumber    Номер транзитного счета.
 * @param transitMemberId         Идентификатор транзита.
 * @param treasuryReference       Справка.
 * @param address                 Адрес.
 * @param phone                   Номер телефона.
 * @param clientType              Тип клиента.
 * @param clientSystem            Система клиента
 * */
public record InPerson(@Size(max = 50) String mdmId, String branch, @Size(max = 12) String taxId, @Size(max = 9) String kpp,
                       ClientType clientType, String clientSystem, InName name, @Size(max = 250) String orgName, @Size(max = 250) String orgOfficialName,
                       InPartyIdentification partyIdentification, @Size(max = 50) String paymentSystemCode,
                       @Size(max = 30) String transitAccountNumber, @Size(max = 30) String transitMemberId,
                       @Size(max = 100) String treasuryReference, InAddress address, @Size(max = 16) String phone) {
}

