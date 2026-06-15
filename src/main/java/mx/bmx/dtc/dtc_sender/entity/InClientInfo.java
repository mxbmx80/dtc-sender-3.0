package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Клиентский контекст.
 * clientId         Идентификатор клиента.
 * clientSystemId   Идентификатор системы, для которой указан идентификатор клиента.
 */
@Builder
@Data
@AllArgsConstructor
public class InClientInfo {
    @Size(max = 50)
    private String clientId;

    @Size(max = 50)
    private String clientSystemId;
}
