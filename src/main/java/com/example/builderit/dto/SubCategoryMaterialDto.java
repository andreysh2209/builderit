package com.example.builderit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryMaterialDto {
    private Long id;
    private String name;
    private String description;
    private Long categoryMaterialId;
    List<MaterialDto> materialDto=new ArrayList<>();
}
