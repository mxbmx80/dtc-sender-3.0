package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;

/**
 * Информация об адресе.
 * @param country        Страна.
 * @param state          Область
 * @param city           Населенный пункт.
 * @param addressLines   Полный Адрес.
 * @param zipCode        Почтовый индекс.
 * */
public record InAddress(@Size(max = 112) String country, @Size(max = 120) String state, @Size(max = 120) String city,
                        @Size(max = 400) String addressLines, @Size(max = 12) String zipCode) {
}

