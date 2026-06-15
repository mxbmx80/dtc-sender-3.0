package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Системная информация.
 * serviceId     Название микросервиса-инициатора.
 */
@Builder
@Data
@AllArgsConstructor
public class InSystemInfo {
    String serviceId;

    @Size(max = 10)
    private String systemId;

    @Size(max = 10)
    private String subSystemId;
}