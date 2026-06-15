package mx.bmx.dtc.dtc_sender.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Информация об адресе.
 *  country        Страна.
 *  state          Область
 *  city           Населенный пункт.
 *  addressLines   Полный Адрес.
 *  zipCode        Почтовый индекс.
 * */
@Builder
@Data
@AllArgsConstructor
public class InAddress {
    @Size(max = 112)
    private String country;
    
    @Size(max = 120)
    private String state;
    
    @Size(max = 120)
    private String city;
    
    @Size(max = 400)
    private String addressLines;
    
    @Size(max = 12)
    private String zipCode;
}

