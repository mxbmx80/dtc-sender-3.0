package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.Builder;

/**
 * Системная информация.
 * @param  serviceId     Название микросервиса-инициатора.
 */
public record InSystemInfo(String serviceId, @Size(max = 10) String systemId, @Size(max = 10) String subSystemId) {

}