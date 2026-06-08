package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;

/**
 * Клиентский контекст.
 * @param  clientId         Идентификатор клиента.
 * @param  clientSystemId   Идентификатор системы, для которой указан идентификатор клиента.
 */
public record InClientInfo(@Size(max = 50) String clientId, @Size(max = 50) String clientSystemId) {
}
