package com.example.builderit.repositories;

import com.example.builderit.models.CategoryMaterial;
import com.example.builderit.models.WorkGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMaterialRepository extends JpaRepository<CategoryMaterial, Long> {
}
