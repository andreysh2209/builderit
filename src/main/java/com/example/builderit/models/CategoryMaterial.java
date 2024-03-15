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
public class CategoryMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany (mappedBy = "categoryMaterial", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<SubCategoryMaterial> subCategoryMaterials = new ArrayList<>();



}
