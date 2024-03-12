package com.example.builderit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="work_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class WorkType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "code")
    private String code;
    @ManyToOne (cascade = CascadeType.REFRESH )
    private SubWorkGroup subWorkGroup;
    @OneToMany (mappedBy = "workType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<WorkTypeMaterials> workTypeMaterials=new ArrayList<>();
    @Column(name = "labor_hour_of_worker")
    private Double laborHourOfWorker;
    @Column(name = "labor_hour_of_machinist")
    private Double laborHourOfMachinist;
    @Column(name = "depreciation_of_machines")
    private Double depreciationOfMachines;
}
