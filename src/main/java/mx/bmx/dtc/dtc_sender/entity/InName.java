package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.Builder;

/**
 * Информация о человеке
 * @param firstName Имя.
 * @param middleName Отчество.
 * @param lastName Фамилия.
 * @param nameLine Полное ФИО.
 */
@Builder
public record InName(@Size(max = 50) String firstName, @Size(max = 50) String middleName, @Size(max = 50) String lastName, @Size(max = 210) String nameLine) {
}
