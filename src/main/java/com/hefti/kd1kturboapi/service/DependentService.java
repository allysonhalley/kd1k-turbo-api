package com.hefti.kd1kturboapi.service;

import com.hefti.kd1kturboapi.dto.DependentDTO;

import java.util.List;

public interface DependentService {

    DependentDTO createDependent(Long peopleId, DependentDTO dependentDTO);

    DependentDTO getDependentById(Long id);

    List<DependentDTO> getDependentsByPeople(Long peopleId);

    DependentDTO updateDependent(Long id, DependentDTO dependentDTO);

    void deleteDependent(Long id);
}