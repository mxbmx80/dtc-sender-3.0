package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Техническая информация о запросе.
 *  ipAddress     IP‑адрес инициатора запроса.
 *  macAddress    MAC‑адрес инициатора запроса.
 *  channel       Канал обслуживания.
 *  signatureType Тип подписи.
 *  signature     Значение цифровой подписи.
 *  extId         Идентификатор транзакции во внешней системе.
 *  extContext    Код внешней системы.
 *  hashSum       Контрольная хэш‑сумма тела сообщения или его части.
 */
@Builder
@Data
@AllArgsConstructor
public class InTechInfo {
     @Size(max = 15)
     private String ipAddress;

     @Size(max = 17)
     private String macAddress;

     @Size(max = 50)
     private String channel;

     @Size(max = 1)
     private String signatureType;

     private String signature;

     @Size(max = 100)
     private String extId;

     @Size(max = 100)
     private String extContext;

     @Size(max = 64)
     private String hashSum;
}

