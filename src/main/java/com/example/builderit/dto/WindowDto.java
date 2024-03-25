package com.example.builderit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WindowDto {
    private Long id;
    private Double width;
    private Double height;
}
