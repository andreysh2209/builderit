package com.example.builderit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkTypeDto {
    private Long id;
    private String name;
    private String code;
    private Long subWorkGroupId;
    private LaborHourDto laborHour;
    private List<MaterialDto> materials;

}
