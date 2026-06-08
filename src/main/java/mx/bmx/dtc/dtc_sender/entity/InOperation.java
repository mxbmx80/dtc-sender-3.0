package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;

/**
 * Операция, проводимая в рамках одного запроса в ПП.
 * @param systemId    Система обслуживания счета
 * @param typeExecutionOrder Очередность выполнения операции по данной стороне транзакции.
 * @param entries     Атомарные операции.
 * */
public record InOperation(int typeExecutionOrder, @Size(max = 20) String systemId, List<InEntry> entries) {

}
