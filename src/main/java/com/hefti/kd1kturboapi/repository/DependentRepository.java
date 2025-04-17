package com.hefti.kd1kturboapi.repository;

import com.hefti.kd1kturboapi.model.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Long> {
    List<Dependent> findByMilitaryPersonnelId(Long personnelId);
}