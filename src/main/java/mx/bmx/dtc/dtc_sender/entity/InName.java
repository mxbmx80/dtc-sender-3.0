package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Информация о человеке
 *  firstName Имя.
 *  middleName Отчество.
 *  lastName Фамилия.
 *  nameLine Полное ФИО.
 */
@Builder
@Data
@AllArgsConstructor
public class InName {
    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String middleName;

    @Size(max = 50)
    private String lastName;

    @Size(max = 210)
    private String nameLine;
}
