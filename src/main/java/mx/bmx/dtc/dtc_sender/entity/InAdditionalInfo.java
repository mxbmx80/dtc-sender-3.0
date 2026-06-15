package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Содержит дополнительные опциональные поля с информацией о транзакции.
 *  ctHashBlock                            Хеш-токен.
 *  dtHashBlock                            Хеш-токен.
 *  ctBlockType                            Код типа блокировки.
 *  dtBlockType                            Код типа блокировки.
 *  ctPublicId                             Идентификатор счета/карты в ПродПрофиле.
 *  dtPublicId                             Идентификатор счета/карты в ПродПрофиле.
 *  ctAmountRub                            Сумма в рублях при переводах в валюте.
 *  dtAmountRub                            Сумма в рублях при переводах в валюте.
 *  ctSbpBankId                            Идентификатор банка-отправителя через СБП.
 *  dtSbpBankId                            Идентификатор банка-отправителя через СБП.
 *  dtDocumentNumber                       Номер кредитного договора(ContractNumber)Номер терминала.
 *  ctDocumentNumber                       Номер кредитного договора(ContractNumber)Номер терминала
 *  ctProductExpirationDate                Дата окончания действия продукта зачисления.
 *  dtProductExpirationDate                Дата окончания действия продукта списания.
 *  ctSecondOrderAccount                   Счет 2-го порядка.
 *  dtSecondOrderAccount                   Счет 2-го порядка.
 *  ctRelatedCard                          Номер доп карты к привязанному счету.
 *  dtRelatedCard                          Номер доп карты к привязанному счету.
 *  platformOperationType                  Тип транзакции через трансграничную платформу.
 *  office                                 Код точки продажи филиала инициировавшего операцию.
 *  conversionRate                         Курс валютообмена.
 *  transactionRef                         Дополнительный id транзакции.
 *  rateRequestId                          Id запроса на льготный курс.
 *  paymentDocumentType                    Вид платежного документа.
 *  creditCodeTypeCBRF                     Код типа документа ЦБ для переводов по реквизитам.
 *  sbpOperationType                       Тип операции СБП ЭБД.
 *  excludeSocialCharges                   Признак исключения социальных выплат.
 *  budgetCode                             Поле (104) платежного поручения РФ.
 *  checkAllowGovernmentPayments           Флаг необходимости проверки возможности зачисления государственных платежей на счет получателя.
 *  meToMe                                 Признак транзакции между своими счетами.
 *  isPending                              Признак исполнения распоряжения в отложенном режиме PNDG (СБП).
 *  kauDb                                  ID транзакции в ФС.
 *  spIbs                                  Номер договора ИБС Спектрум.
 *  flagDover                              Флаг доверенного лица.
 *  processingCosts                        Детали расходов.
 *  b77                                    Поле 77В (для формирования МТ103).
 *  dev                                    Признак электронного документа.
 *  f407                                   «legacyShit».
 *  sendGZKH                               «legacyShit».
 *  debugCode                              «legacyShit».
 *  techSection                            «legacyShit».
 *  d57                                    «legacyShit».
 *  isRepaired                             Признак исправительной/урегулирующей транзакции
 *  incomeType                             Код вида дохода
 *  payrollRef                             Имя реестра зачисления
 *  arrestAmount                           Сумма, подлежащая аресту
 *  arrestCurrency                         Валюта суммы ареста
 *  coverageDocRef                         Идентификатор документа о покрытии
 *  notificationCode                       Код СМС информирования
 *  amountType                             Тип суммы сделки
 *  rateType                               Тип тарифа
 *  cashTransactionCode                    Код кассовой операции (Кассовый символ)
 *  beneficiaryNameCheck                   Флаг необходимости проверки ФИО получателя.
 * */
@Builder
@Data
@AllArgsConstructor
public class InAdditionalInfo {
    private Long ctHashBlock;

    private Long  dtHashBlock;

    private @Size(max = 25) String ctBlockType;

    private @Size(max = 25) String dtBlockType;


    private @Size(max = 50) String ctPublicId;

    private @Size(max = 50) String dtPublicId;

    private BigDecimal ctAmountRub;

    private BigDecimal dtAmountRub;

    private @Size(max = 100) String ctSbpBankId;

    private @Size(max = 100) String dtSbpBankId;

    private @Size(max = 50) String dtDocumentNumber;

    private LocalDateTime ctProductExpirationDate;

    private LocalDateTime dtProductExpirationDate;

    private @Size(max = 50) String ctSecondOrderAccount;

    private @Size(max = 50) String dtSecondOrderAccount;

    private @Size(max = 50) String ctDocumentNumber;

    private @Size(max = 50) String ctRelatedCard;

    private @Size(max = 50) String dtRelatedCard;

    private @Size(max = 210) String platformOperationType;

    private @Size(max = 30) String office;

    private BigDecimal conversionRate;

    private @Size(max = 50) String transactionRef;

    private @Size(max = 50) String rateRequestId;

    private @Size(max = 100) String paymentDocumentType;

    private @Size(max = 50) String creditCodeTypeCBRF;

    private @Size(max = 8) String sbpOperationType;

    private Boolean excludeSocialCharges;

    private @Size(max = 100) String budgetCode;

    private Boolean checkAllowGovernmentPayments;

    private Boolean meToMe;

    private Boolean isPending;

    private @Size(max = 50) String kauDb;

    private @Size(max = 250) String spIbs;

    private @Size(max = 50) String flagDover;

    private @Size(max = 250) String processingCosts;

    private @Size(max = 250) String f407;

    private String d57;

    private @Size(max = 250) String b77;

    private @Size(max = 50) String dev;

    private @Size(max = 250) String sendGZKH;

    private @Size(max = 100) String debugCode;

    private @Size(max = 100) String techSection;

    private InTaxInfoCftm taxInfoCftm;

    private String digitalRubOperationId;

    private Boolean isRepaired;

    private @Size(max = 255) String incomeType;

    private @Size(max = 255) String payrollRef;

    private BigDecimal arrestAmount;

    private @Size(max = 10) String arrestCurrency;

    private @Size(max = 255) String coverageDocRef;

    private @Size(max = 255) String notificationCode;

    private @Size(max = 255) String amountType;

    private @Size(max = 255) String rateType;

    private @Size(max = 255) String cashTransactionCode;

    private Boolean beneficiaryNameCheck;

}
