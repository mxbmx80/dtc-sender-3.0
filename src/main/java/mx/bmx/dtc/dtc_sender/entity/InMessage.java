package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class InMessage {
    @Valid
    private InTechInfo techInfo;

    @Valid
    private InHeader header;

    @Valid
    private InTransactionInfo transactionInfo;

    @Valid
    private InTransactionData transactionData;

    @Valid
    private InLegacyTransactionData legacyTransactionData;

    @Valid
    private InAdditionalInfo additionalInfo;
}
