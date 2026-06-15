package mx.bmx.dtc.dtc_sender.entity;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Информация о счете, карте, депозитном договоре или ином объекте списания.
 *  productType            Тип продукта (счёт, карта, депозит или иной объект).
 *  accountNumber          Тип счета(мастер, текущий).
 *  systemId               Номер счета/PAN карты.
 *  accountType            Код филиала счета.
 *  bci                    Идентификатор бизнес-компонента.
 *  codeClient             legacy-идентификатор клиента.
 *  correspondentBank      Банк\Клиент корреспондент
 *  corshetPol             Корсчёт банка получателя/Единый казначейский счет
 *  businessOperationOrder Приоритет исполнения проводки
 * */
@Builder
@Data
@AllArgsConstructor
public class InLegacyAccount {
    private String docProcessing;

    @Size(max = 12)
    private String productType;

    @Size(max = 20)
    private String systemId;

    private Integer businessOperationOrder;

    private String accountType;

    @Size(max = 50)
    private String accountNumber;

    private String bci;

    @Size(max = 100)
    private String codeClient;

    private String corshetPol;

    private InLegacyCorrespondentBankcorrespondentBank correspondentBank;

}