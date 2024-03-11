package com.example.builderit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDto {
    private Long id;
    private String name;
    private String code;
    private String measurementType;
    private Double price;
    private Double qnt;
}
