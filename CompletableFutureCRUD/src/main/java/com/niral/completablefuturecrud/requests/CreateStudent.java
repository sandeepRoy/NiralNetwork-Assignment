package com.niral.completablefuturecrud.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudent {
    private String name;
    private Integer age;
    private String city;
}
