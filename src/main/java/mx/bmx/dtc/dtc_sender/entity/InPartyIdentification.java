package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Филиал
 *  organizationId Идентификатор Филиала.
 *  tspId          Идентификатор Торгово-сервисного предприятия.
 * */
@Data
@Builder
@AllArgsConstructor
public class InPartyIdentification {
    @Size(max = 50)
    private String organizationId;

    @Size(max = 50)
    private String tspId;
}
