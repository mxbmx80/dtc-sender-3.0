package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Информация о транзакции
 * @param instructionId            Идентификатор платежной инструкции на стороне оркестратора.
 * @param acceptControl            Тип проверки, которую необходимо провести перед исполнением транзакции
 * @param tbi                      Бизнес-ключ записи в справочника
 * @param eventCode                ВКУС (внутренний код учетного события)
 * @param purpose                  Назначение перевода/платежа
 * @param fullTransactionName      Полное описание транзакции
 * @param paymentDocNumber         Номер платежного документа
 * @param extDate                  Дата расчетов внешней транзакции
 * @param paymentOperationDate     Дата операционного дня выполнения операции
 * @param sender                   Информация об отправителе
 * @param receiver                 Информация об получателе
 * @param organizationUnit         Код филиала, инициализировавшего транзакцию
 * @param kbo                      Код КБО(Код банковской операции).
 * */

public record InTransactionInfo(UUID instructionId, @Size(max = 255) String tbi, LocalDate paymentOperationDate,
                                @Size(max = 10) String kbo, String acceptControl, Long acceptWaitingTime,
                                @Size(max = 20) String eventCode, @Size(max = 250) String purpose, @Size(max = 210)
                                String fullTransactionName, @Size(max = 50) String paymentDocNumber,
                                @Size(max = 20) String organizationUnit, LocalDate extDate,
                                LocalDate settlementDate, InPerson sender, InPerson receiver) {

}
