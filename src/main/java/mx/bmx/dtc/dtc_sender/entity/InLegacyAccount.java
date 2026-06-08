package mx.bmx.dtc.dtc_sender.entity;


import jakarta.validation.constraints.Size;

/**
 * Информация о счете, карте, депозитном договоре или ином объекте списания.
 * @param productType            Тип продукта (счёт, карта, депозит или иной объект).
 * @param accountNumber          Тип счета(мастер, текущий).
 * @param systemId               Номер счета/PAN карты.
 * @param accountType            Код филиала счета.
 * @param bci                    Идентификатор бизнес-компонента.
 * @param codeClient             legacy-идентификатор клиента.
 * @param correspondentBank      Банк\Клиент корреспондент
 * @param corshetPol             Корсчёт банка получателя/Единый казначейский счет
 * @param businessOperationOrder Приоритет исполнения проводки
 * */
public record InLegacyAccount(String docProcessing, @Size(max = 12) String productType, @Size(max = 20) String systemId,
                              Integer businessOperationOrder, String accountType, @Size(max = 50) String accountNumber,
                              String bci, @Size(max = 100) String codeClient, String corshetPol,
                              InLegacyCorrespondentBankcorrespondentBank correspondentBank) {

}