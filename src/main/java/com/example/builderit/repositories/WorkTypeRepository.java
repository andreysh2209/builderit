package com.example.builderit.repositories;

import com.example.builderit.models.SubWorkGroup;
import com.example.builderit.models.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkTypeRepository extends JpaRepository<WorkType, Long> {

}
