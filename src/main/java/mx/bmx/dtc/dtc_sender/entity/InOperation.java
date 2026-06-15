package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Операция, проводимая в рамках одного запроса в ПП.
 *  systemId    Система обслуживания счета
 *  typeExecutionOrder Очередность выполнения операции по данной стороне транзакции.
 *  entries     Атомарные операции.
 * */
@Builder
@Data
@AllArgsConstructor
public class InOperation {
    private int typeExecutionOrder;

    @Size(max = 20)
    private  String systemId;

    private List<InEntry> entries;
}
