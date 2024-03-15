package com.example.builderit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category_materials")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubCategoryMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne (cascade = CascadeType.REFRESH )
    private CategoryMaterial categoryMaterial;
    @OneToMany (mappedBy = "subCategoryMaterial", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Material> materials=new ArrayList<>();


}
