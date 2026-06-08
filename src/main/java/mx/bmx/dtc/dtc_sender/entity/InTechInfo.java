package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * Техническая информация о запросе.
 *
 * @param ipAddress     IP‑адрес инициатора запроса.
 * @param macAddress    MAC‑адрес инициатора запроса.
 * @param channel       Канал обслуживания.
 * @param signatureType Тип подписи.
 * @param signature     Значение цифровой подписи.
 * @param extId         Идентификатор транзакции во внешней системе.
 * @param extContext    Код внешней системы.
 * @param hashSum       Контрольная хэш‑сумма тела сообщения или его части.
 */
@Builder
public record InTechInfo(@Size(max = 15) String ipAddress, @Size(max = 17) String macAddress,
                         @Size(max = 50) String channel, @Size(max = 1) String signatureType, String signature,
                         @Size(max = 100) String extId, @Size(max = 100) String extContext,
                         @Size(max = 64) String hashSum) {

}

