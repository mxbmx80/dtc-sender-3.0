package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Входящий запрос на перевод.
 *  techInfo               Техническая информация.
 *  header                 Информация о заголовках.
 *  transactionData        Финансовая транзакция.
 *  legacyTransactionData  Блок с данными по legacy-операциям.
 *  additionalInfo         Содержит дополнительные опциональные поля с информацией о транзакции.
 */
@Data
@Builder
@AllArgsConstructor
public class InMessage {
    @Valid
    private InTechInfo techInfo;

    @Valid
    private InHeader header;

    @Valid
    private InTransactionInfo transactionInfo;

    @Valid
    private InTransactionData transactionData;

    @Valid
    private InLegacyTransactionData legacyTransactionData;

    @Valid
    private InAdditionalInfo additionalInfo;
}
