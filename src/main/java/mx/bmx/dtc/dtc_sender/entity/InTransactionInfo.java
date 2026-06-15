package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Информация о транзакции
 *  instructionId            Идентификатор платежной инструкции на стороне оркестратора.
 *  acceptControl            Тип проверки; которую необходимо провести перед исполнением транзакции
 *  tbi                      Бизнес-ключ записи в справочника
 *  eventCode                ВКУС (внутренний код учетного события)
 *  purpose                  Назначение перевода/платежа
 *  fullTransactionName      Полное описание транзакции
 *  paymentDocNumber         Номер платежного документа
 *  extDate                  Дата расчетов внешней транзакции
 *  paymentOperationDate     Дата операционного дня выполнения операции
 *  sender                   Информация об отправителе
 *  receiver                 Информация об получателе
 *  organizationUnit         Код филиала; инициализировавшего транзакцию
 *  kbo                      Код КБО(Код банковской операции).
 * */
@Builder
@Data
@AllArgsConstructor
public class InTransactionInfo {
     private UUID instructionId;

     @Size(max = 255)
     private String tbi;

     private LocalDate paymentOperationDate;

     @Size(max = 10)
     private String kbo;

     private String acceptControl;

     private Long acceptWaitingTime;

     @Size(max = 20)
     private String eventCode;

     @Size(max = 250)
     private String purpose;

     @Size(max = 210)
     private String fullTransactionName;

     @Size(max = 50)
     private String paymentDocNumber;

     @Size(max = 20)
     private String organizationUnit;

     private LocalDate extDate;

     private LocalDate settlementDate;

     private InPerson sender;

     private InPerson receiver;

}
