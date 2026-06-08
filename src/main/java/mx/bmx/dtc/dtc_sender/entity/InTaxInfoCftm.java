package mx.bmx.dtc.dtc_sender.entity;

/**
  Блок с информацией по налогам для CFT MAIN.
  @param sPayStatus             Статус составителя расчетного документа.
 * @param sBudgetCode            Код бюджетной классификации (КБК).
 * @param sOkato                 Код ОКАТО.
 * @param sTaxReason             Код ОКАТО.
 * @param sTaxPeriod             Налоговый период.
 * @param sTaxInstructLabel      Номер налогового документа.
 * @param sTaxDate               Дата налогового документа.
 * @param sUnicode               Уникальный идентификатор платежа.
 * @param sCodePurpose           Назначение платежа.
 * @param nPayQueue              Очередность платежа.
 * */

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record  InTaxInfoCftm(@Size(max = 100) String sPayStatus, @Size(max = 50) String sBudgetCode,
                             @Size(max = 100) String sOkato, @Size(max = 250) String sTaxReason,
                             @Size(max = 50) String sTaxPeriod, @Size(max = 50) String sTaxInstructLabel,
                             LocalDate sTaxDate, @Size(max = 30) String sUnicode, @Size(max = 250) String sCodePurpose,
                             Integer nPayQueue) {

}
