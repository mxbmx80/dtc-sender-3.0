package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Содержит дополнительные опциональные поля с информацией о транзакции.
 * @param ctHashBlock                            Хеш-токен.
 * @param dtHashBlock                            Хеш-токен.
 * @param ctBlockType                            Код типа блокировки.
 * @param dtBlockType                            Код типа блокировки.
 * @param ctPublicId                             Идентификатор счета/карты в ПродПрофиле.
 * @param dtPublicId                             Идентификатор счета/карты в ПродПрофиле.
 * @param ctAmountRub                            Сумма в рублях при переводах в валюте.
 * @param dtAmountRub                            Сумма в рублях при переводах в валюте.
 * @param ctSbpBankId                            Идентификатор банка-отправителя через СБП.
 * @param dtSbpBankId                            Идентификатор банка-отправителя через СБП.
 * @param dtDocumentNumber                       Номер кредитного договора(ContractNumber)Номер терминала.
 * @param ctDocumentNumber                       Номер кредитного договора(ContractNumber)Номер терминала
 * @param ctProductExpirationDate                Дата окончания действия продукта зачисления.
 * @param dtProductExpirationDate                Дата окончания действия продукта списания.
 * @param ctSecondOrderAccount                   Счет 2-го порядка.
 * @param dtSecondOrderAccount                   Счет 2-го порядка.
 * @param ctRelatedCard                          Номер доп карты к привязанному счету.
 * @param dtRelatedCard                          Номер доп карты к привязанному счету.
 * @param platformOperationType                  Тип транзакции через трансграничную платформу.
 * @param office                                 Код точки продажи филиала инициировавшего операцию.
 * @param conversionRate                         Курс валютообмена.
 * @param transactionRef                         Дополнительный id транзакции.
 * @param rateRequestId                          Id запроса на льготный курс.
 * @param paymentDocumentType                    Вид платежного документа.
 * @param creditCodeTypeCBRF                     Код типа документа ЦБ для переводов по реквизитам.
 * @param sbpOperationType                       Тип операции СБП ЭБД.
 * @param excludeSocialCharges                   Признак исключения социальных выплат.
 * @param budgetCode                             Поле (104) платежного поручения РФ.
 * @param checkAllowGovernmentPayments           Флаг необходимости проверки возможности зачисления государственных платежей на счет получателя.
 * @param meToMe                                 Признак транзакции между своими счетами.
 * @param isPending                              Признак исполнения распоряжения в отложенном режиме PNDG (СБП).
 * @param kauDb                                  ID транзакции в ФС.
 * @param spIbs                                  Номер договора ИБС Спектрум.
 * @param flagDover                              Флаг доверенного лица.
 * @param processingCosts                        Детали расходов.
 * @param b77                                    Поле 77В (для формирования МТ103).
 * @param dev                                    Признак электронного документа.
 * @param f407                                   «legacyShit».
 * @param sendGZKH                               «legacyShit».
 * @param debugCode                              «legacyShit».
 * @param techSection                            «legacyShit».
 * @param d57                                    «legacyShit».
 * @param isRepaired                             Признак исправительной/урегулирующей транзакции
 * @param incomeType                             Код вида дохода
 * @param payrollRef                             Имя реестра зачисления
 * @param arrestAmount                           Сумма, подлежащая аресту
 * @param arrestCurrency                         Валюта суммы ареста
 * @param coverageDocRef                         Идентификатор документа о покрытии
 * @param notificationCode                       Код СМС информирования
 * @param amountType                             Тип суммы сделки
 * @param rateType                               Тип тарифа
 * @param cashTransactionCode                    Код кассовой операции (Кассовый символ)
 * @param beneficiaryNameCheck                   Флаг необходимости проверки ФИО получателя.
 * */
public record InAdditionalInfo(Long ctHashBlock, Long  dtHashBlock, @Size(max = 25) String ctBlockType, @Size(max = 25) String dtBlockType,
                               @Size(max = 50) String ctPublicId, @Size(max = 50) String dtPublicId, BigDecimal ctAmountRub,
                               BigDecimal dtAmountRub , @Size(max = 100) String ctSbpBankId, @Size(max = 100) String dtSbpBankId,
                               @Size(max = 50) String dtDocumentNumber, LocalDateTime ctProductExpirationDate,
                               LocalDateTime dtProductExpirationDate, @Size(max = 50) String ctSecondOrderAccount,
                               @Size(max = 50) String dtSecondOrderAccount, @Size(max = 50) String ctDocumentNumber,
                               @Size(max = 50) String ctRelatedCard, @Size(max = 50) String dtRelatedCard,
                               @Size(max = 210) String platformOperationType, @Size(max = 30) String office,
                               BigDecimal conversionRate, @Size(max = 50) String transactionRef,
                               @Size(max = 50) String rateRequestId, @Size(max = 100) String paymentDocumentType,
                               @Size(max = 50) String creditCodeTypeCBRF, @Size(max = 8) String sbpOperationType,
                               Boolean excludeSocialCharges, @Size(max = 100) String budgetCode,
                               Boolean checkAllowGovernmentPayments, Boolean meToMe,  Boolean isPending,
                               @Size(max = 50) String kauDb, @Size(max = 250) String spIbs, @Size(max = 50) String flagDover, @Size(max = 250) String processingCosts,
                               @Size(max = 250) String f407, String d57, @Size(max = 250) String b77, @Size(max = 50) String dev,
                               @Size(max = 250) String sendGZKH, @Size(max = 100) String debugCode, @Size(max = 100) String techSection,
                               InTaxInfoCftm taxInfoCftm, String digitalRubOperationId, Boolean isRepaired,
                               @Size(max = 255) String incomeType, @Size(max = 255) String payrollRef, BigDecimal arrestAmount,
                               @Size(max = 10) String arrestCurrency, @Size(max = 255) String coverageDocRef,
                               @Size(max = 255) String notificationCode, @Size(max = 255) String amountType,
                               @Size(max = 255) String rateType, @Size(max = 255) String cashTransactionCode, Boolean beneficiaryNameCheck) {

}
