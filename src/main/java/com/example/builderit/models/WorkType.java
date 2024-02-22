package com.example.builderit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "description")
    private String description;
    @ManyToOne (cascade = CascadeType.REFRESH )
    private SubWorkGroup subWorkGroup;
}
