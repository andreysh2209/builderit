package com.example.builderit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryMaterialDto {
    private Long id;
    private String name;
    private String description;
    List<SubCategoryMaterialDto> subCategoryMaterialDto = new ArrayList<>();

}
