package com.example.builderit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "work_type_materials")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkTypeMaterials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne (cascade = CascadeType.REFRESH )
    private WorkType workType;
    @ManyToOne (cascade = CascadeType.REFRESH )
    private Material material;
}
