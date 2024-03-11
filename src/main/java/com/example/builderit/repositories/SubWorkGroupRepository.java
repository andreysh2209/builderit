package com.example.builderit.repositories;

import com.example.builderit.models.SubWorkGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubWorkGroupRepository extends JpaRepository<SubWorkGroup, Long> {
    List<SubWorkGroup> findAllByWorkGroupId(Long workGroupId);
}
