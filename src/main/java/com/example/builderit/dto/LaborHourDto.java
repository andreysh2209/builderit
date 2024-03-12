package com.example.builderit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaborHourDto {
    private Long id;
    private Double laborHourOfWorker;
    private Double laborHourOfMachinist;
    private Double depreciationOfMachines;
}
