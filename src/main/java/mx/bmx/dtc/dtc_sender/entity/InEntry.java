package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Атомарная операция.
 *
 * index                  Числовой порядок выполнения атомарной операции в продуктовом процессоре.
 *  direction              Направление атомарной операции.
 *  productType            Тип продукта (счёт; карта; депозит или иной объект).
 *  prepareOperationId     Идентификатор операции от прод процессора
 *  accountType            Тип счета(мастер; текущий)
 *  productId              Идентификатор продукта
 *  registerId             Идентификатор регистрации
 *  productAccountId       Идентификатор счета продукта
 *  amount                 Информация о сумме и валюте
 *  purpose                Назначение перевода/платежа
 *  accountNumber          Номер счета
 *  registerType           Тип регистра
 *  productInstanceVersion Версия экземпляра продукта
 *  businessOperationOrder Приоритет исполнения проводки
 */

@Builder
@Data
@AllArgsConstructor
public class InEntry {
    private int index;

    private Direction direction;

    @Size(max = 12)
    private String productType;

    private int businessOperationOrder;

    private Amount amount;

    @Size(max = 50)
    private String prepareOperationId;

    @Size(max = 50)
    private String accountType;

    private String accountNumber;

    private String productId;

    @Size(max = 50)
    private String registerId;

    @Size(max = 50)
    private String productAccountId;

    private String registerType;

    @Size(max = 250)
    private String purpose;

    private Long productInstanceVersion;
}
