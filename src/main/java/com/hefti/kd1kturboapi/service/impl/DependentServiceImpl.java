package com.hefti.kd1kturboapi.service.impl;

import com.hefti.kd1kturboapi.dto.DependentDTO;
import com.hefti.kd1kturboapi.exception.ResourceNotFoundException;
import com.hefti.kd1kturboapi.model.Dependent;
import com.hefti.kd1kturboapi.model.MilitaryPeople;
import com.hefti.kd1kturboapi.repository.DependentRepository;
import com.hefti.kd1kturboapi.repository.MilitaryPeopleRepository;
import com.hefti.kd1kturboapi.service.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DependentServiceImpl implements DependentService {

    private final DependentRepository dependentRepository;
    private final MilitaryPeopleRepository militaryPeopleRepository;

    @Autowired
    public DependentServiceImpl(DependentRepository dependentRepository,
                                MilitaryPeopleRepository militaryPeopleRepository) {
        this.dependentRepository = dependentRepository;
        this.militaryPeopleRepository = militaryPeopleRepository;
    }

    @Override
    @Transactional
    public DependentDTO createDependent(Long peopleId, DependentDTO dependentDTO) {
        // Find the military people by ID
        MilitaryPeople people = militaryPeopleRepository.findById(peopleId)
                .orElseThrow(() -> new ResourceNotFoundException("Military People", "id", peopleId));

        // Convert DTO to entity
        Dependent dependent = new Dependent();
        dependent.setName(dependentDTO.name());
        dependent.setBirthDate(dependentDTO.birthDate());
        dependent.setMilitaryPeople(people);

        // Save to database
        Dependent savedDependent = dependentRepository.save(dependent);

        // Convert saved entity back to DTO
        return convertToDTO(savedDependent);
    }

    @Override
    @Transactional(readOnly = true)
    public DependentDTO getDependentById(Long id) {
        Dependent dependent = dependentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dependent", "id", id));

        return convertToDTO(dependent);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DependentDTO> getDependentsByPeople(Long peopleId) {
        List<Dependent> dependents = dependentRepository.findByMilitaryPeopleId(peopleId);

        return dependents.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DependentDTO updateDependent(Long id, DependentDTO dependentDTO) {
        // Check if dependent exists
        Dependent dependent = dependentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dependent", "id", id));

        // Update entity fields
        dependent.setName(dependentDTO.name());
        dependent.setBirthDate(dependentDTO.birthDate());

        // Save changes
        Dependent updatedDependent = dependentRepository.save(dependent);

        // Convert updated entity to DTO
        return convertToDTO(updatedDependent);
    }

    @Override
    @Transactional
    public void deleteDependent(Long id) {
        // Check if dependent exists
        Dependent dependent = dependentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dependent", "id", id));

        // Delete dependent
        dependentRepository.delete(dependent);
    }

    // Helper method to convert entity to DTO
    private DependentDTO convertToDTO(Dependent entity) {
        if (entity == null) {
            return null;
        }

        return DependentDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .birthDate(entity.getBirthDate())
                .build();
    }
}