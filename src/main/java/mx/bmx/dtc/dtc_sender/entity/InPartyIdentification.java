package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;

/**
 * Филиал
 * @param organizationId Идентификатор Филиала.
 * @param tspId          Идентификатор Торгово-сервисного предприятия.
 * */
public record InPartyIdentification(@Size(max = 50) String organizationId, @Size(max = 50)String tspId) {
}
