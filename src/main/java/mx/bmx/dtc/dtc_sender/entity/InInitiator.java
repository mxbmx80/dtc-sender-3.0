package mx.bmx.dtc.dtc_sender.entity;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Информация об инициаторе.
 *  systemInfo          Системная информация.
 *  clientInfo          Клиентский контекст.
 *  operatorInfo        Информация об операторе.
 */
@Builder
@Data
@AllArgsConstructor
public class InInitiator {
    private InSystemInfo systemInfo;

    @Nullable
    private InClientInfo clientInfo;

    @Nullable
    private InOperatorInfo operatorInfo;
}