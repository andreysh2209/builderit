package com.example.builderit.models;

import com.example.builderit.enums.MeasurementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "materials")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "code")
    private String code;
    @Enumerated(EnumType.STRING)
    private MeasurementType measurementType;
    @Column (name="price")
    private Double price;
    @OneToMany (mappedBy = "material", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<WorkTypeMaterials> workTypeMaterials=new ArrayList<>();
    @ManyToOne (cascade = CascadeType.REFRESH )
    private  SubCategoryMaterial subCategoryMaterial;
}
