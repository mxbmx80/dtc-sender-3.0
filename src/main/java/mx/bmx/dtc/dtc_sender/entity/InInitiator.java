package mx.bmx.dtc.dtc_sender.entity;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * Информация об инициаторе.
 *
 * @param systemInfo          Системная информация.
 * @param clientInfo          Клиентский контекст.
 * @param operatorInfo        Информация об операторе.
 */
public record InInitiator(InSystemInfo systemInfo, @Nullable InClientInfo clientInfo, @Nullable InOperatorInfo operatorInfo) {

}