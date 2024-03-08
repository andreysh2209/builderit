package com.example.builderit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "coefficients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Coefficient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cost_of_one_hour_of_work")
    private Double costOfOneHourOfWork;
    @Column(name = "transport_coefficient")
    private Double transportCoefficient;
    @Column(name = "overhead_costs")
    private Double overheadCosts;
    @Column(name = "planned_profit")
    private Double plannedProfit;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "date_Of_Change")
    private LocalDate dateOfChange;
}
