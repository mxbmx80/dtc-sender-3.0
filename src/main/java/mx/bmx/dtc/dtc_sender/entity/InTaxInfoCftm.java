package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
  Блок с информацией по налогам для CFT MAIN.
   sPayStatus             Статус составителя расчетного документа.
 *  sBudgetCode            Код бюджетной классификации (КБК).
 *  sOkato                 Код ОКАТО.
 *  sTaxReason             Код ОКАТО.
 *  sTaxPeriod             Налоговый период.
 *  sTaxInstructLabel      Номер налогового документа.
 *  sTaxDate               Дата налогового документа.
 *  sUnicode               Уникальный идентификатор платежа.
 *  sCodePurpose           Назначение платежа.
 *  nPayQueue              Очередность платежа.
 * */
@Builder
@Data
@AllArgsConstructor
public class  InTaxInfoCftm {
    @Size(max = 100)
    private String sPayStatus;

    @Size(max = 50)
    private String sBudgetCode;

    @Size(max = 100)
    private String sOkato;

    @Size(max = 250)
    private String sTaxReason;

    @Size(max = 50)
    private String sTaxPeriod;

    @Size(max = 50)
    private String sTaxInstructLabel;

    private LocalDate sTaxDate;

    @Size(max = 30)
    private String sUnicode;

    @Size(max = 250)
    private String sCodePurpose;

    private Integer nPayQueue;

}
