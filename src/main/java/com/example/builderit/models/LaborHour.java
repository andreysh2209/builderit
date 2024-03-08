package com.example.builderit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "labor_hours")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LaborHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "labor_hour_of_worker")
    private Double laborHourOfWorker;
    @Column(name = "labor_hour_of_machinist")
    private Double laborHourOfMachinist;
    @Column(name = "depreciation_of_machines")
    private Double DepreciationOfMachines;
    @ManyToOne (cascade = CascadeType.REFRESH )
    private WorkType workType;
}
