package ru.zhegalov.demo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class PersonDto {
    private String number;
}
