package com.example.builderit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubWorkGroupDto {
    private Long id;
    private  String name;
    private String description;
    private Long workGroupsId;
}
