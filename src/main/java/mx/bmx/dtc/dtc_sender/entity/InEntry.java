package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.Builder;

/**
 * Атомарная операция.
 *
 * @param index                  Числовой порядок выполнения атомарной операции в продуктовом процессоре.
 * @param direction              Направление атомарной операции.
 * @param productType            Тип продукта (счёт, карта, депозит или иной объект).
 * @param prepareOperationId     Идентификатор операции от прод процессора
 * @param accountType            Тип счета(мастер, текущий)
 * @param productId              Идентификатор продукта
 * @param registerId             Идентификатор регистрации
 * @param productAccountId       Идентификатор счета продукта
 * @param amount                 Информация о сумме и валюте
 * @param purpose                Назначение перевода/платежа
 * @param accountNumber          Номер счета
 * @param registerType           Тип регистра
 * @param productInstanceVersion Версия экземпляра продукта
 * @param businessOperationOrder Приоритет исполнения проводки
 */

public record InEntry(int index, Direction direction, @Size(max = 12) String productType, int businessOperationOrder, Amount amount,
    @Size(max = 50) String prepareOperationId, @Size(max = 50) String accountType, String accountNumber, String productId, @Size(max = 50) String registerId,
    @Size(max = 50) String productAccountId, String registerType, @Size(max = 250) String purpose, Long productInstanceVersion) {
}
