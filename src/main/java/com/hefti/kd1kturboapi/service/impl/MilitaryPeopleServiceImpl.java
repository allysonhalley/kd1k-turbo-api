package com.hefti.kd1kturboapi.service.impl;

import com.hefti.kd1kturboapi.dto.*;
import com.hefti.kd1kturboapi.exception.ResourceNotFoundException;
import com.hefti.kd1kturboapi.model.*;
import com.hefti.kd1kturboapi.repository.*;
import com.hefti.kd1kturboapi.service.MilitaryPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MilitaryPeopleServiceImpl implements MilitaryPeopleService {

    private final MilitaryPeopleRepository militaryPeopleRepository;
    private final MilitaryRankRepository militaryRankRepository;

    @Autowired
    public MilitaryPeopleServiceImpl(MilitaryPeopleRepository militaryPeopleRepository,
                                        MilitaryRankRepository militaryRankRepository) {
        this.militaryPeopleRepository = militaryPeopleRepository;
        this.militaryRankRepository = militaryRankRepository;
    }

    @Override
    @Transactional
    public MilitaryPeopleDTO createPeople(MilitaryPeopleDTO peopleDTO) {
        // Convert DTO to entity
        MilitaryPeople people = convertToEntity(peopleDTO);

        // Save to database
        MilitaryPeople savedPeople = militaryPeopleRepository.save(people);

        // Convert saved entity back to DTO
        return convertToDTO(savedPeople);
    }

    @Override
    @Transactional(readOnly = true)
    public MilitaryPeopleDTO getPeopleById(Long id) {
        MilitaryPeople people = militaryPeopleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Military People", "id", id));

        return convertToDTO(people);
    }

    @Override
    @Transactional(readOnly = true)
    public MilitaryPeopleDTO getPeopleByCpf(String cpf) {
        MilitaryPeople people = militaryPeopleRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Military People", "cpf", cpf));

        return convertToDTO(people);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MilitaryPeopleDTO> getAllPeople() {
        List<MilitaryPeople> peopleList = militaryPeopleRepository.findAll();

        return peopleList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MilitaryPeopleDTO> getPeopleByRank(Long rankId) {
        List<MilitaryPeople> peopleList = militaryPeopleRepository.findByRankId(rankId);

        return peopleList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MilitaryPeopleDTO updatePeople(Long id, MilitaryPeopleDTO peopleDTO) {
        // Check if people exists
        MilitaryPeople people = militaryPeopleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Military People", "id", id));

        // Update entity fields
        updateEntityFields(people, peopleDTO);

        // Save changes
        MilitaryPeople updatedPeople = militaryPeopleRepository.save(people);

        // Convert updated entity to DTO
        return convertToDTO(updatedPeople);
    }

    @Override
    @Transactional
    public void deletePeople(Long id) {
        // Check if people exists
        MilitaryPeople people = militaryPeopleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Military People", "id", id));

        // Delete people
        militaryPeopleRepository.delete(people);
    }

    // Helper methods to convert between entity and DTO

    private MilitaryPeople convertToEntity(MilitaryPeopleDTO dto) {
        if (dto == null) {
            return null;
        }

        MilitaryPeople people = new MilitaryPeople();

        // Fill basic fields
        people.setId(dto.id());
        people.setFullName(dto.fullName());
        people.setWarName(dto.warName());
        people.setCpf(dto.cpf());
        people.setBirthDate(dto.birthDate());
        people.setBirthMonth(dto.birthMonth());
        people.setMaritalStatus(dto.maritalStatus());
        people.setGender(dto.gender());
        people.setReligion(dto.religion());
        people.setBloodType(dto.bloodType());
        people.setRhFactor(dto.rhFactor());
        people.setHeadSize(dto.headSize());
        people.setShoeSize(dto.shoeSize());
        people.setBootSize(dto.bootSize());
        people.setShirtSize(dto.shirtSize());
        people.setPantsSize(dto.pantsSize());
        people.setShortsSize(dto.shortsSize());
        people.setSwimwearSize(dto.swimwearSize());
        people.setSwimTrunksSize(dto.swimTrunksSize());
        people.setOrganDonor(dto.organDonor());
        people.setBloodDonor(dto.bloodDonor());
        people.setCasMember(dto.casMember());
        people.setSismepeUser(dto.sismepeUser());
        people.setHasAccidentCertificate(dto.hasAccidentCertificate());
        people.setHasChronicDisease(dto.hasChronicDisease());
        people.setControlledMedication(dto.controlledMedication());
        people.setHasAllergies(dto.hasAllergies());

        // Set rank
        if (dto.rank() != null && dto.rank().id() != null) {
            MilitaryRank rank = militaryRankRepository.findById(dto.rank().id())
                    .orElseThrow(() -> new ResourceNotFoundException("Military Rank", "id", dto.rank().id()));
            people.setRank(rank);
        }

        // Other relationships would be configured here...

        return people;
    }

    private void updateEntityFields(MilitaryPeople entity, MilitaryPeopleDTO dto) {
        if (dto == null) {
            return;
        }

        // Update basic fields
        entity.setFullName(dto.fullName());
        entity.setWarName(dto.warName());
        entity.setBirthDate(dto.birthDate());
        entity.setBirthMonth(dto.birthMonth());
        entity.setMaritalStatus(dto.maritalStatus());
        entity.setGender(dto.gender());
        entity.setReligion(dto.religion());
        entity.setBloodType(dto.bloodType());
        entity.setRhFactor(dto.rhFactor());
        entity.setHeadSize(dto.headSize());
        entity.setShoeSize(dto.shoeSize());
        entity.setBootSize(dto.bootSize());
        entity.setShirtSize(dto.shirtSize());
        entity.setPantsSize(dto.pantsSize());
        entity.setShortsSize(dto.shortsSize());
        entity.setSwimwearSize(dto.swimwearSize());
        entity.setSwimTrunksSize(dto.swimTrunksSize());
        entity.setOrganDonor(dto.organDonor());
        entity.setBloodDonor(dto.bloodDonor());
        entity.setCasMember(dto.casMember());
        entity.setSismepeUser(dto.sismepeUser());
        entity.setHasAccidentCertificate(dto.hasAccidentCertificate());
        entity.setHasChronicDisease(dto.hasChronicDisease());
        entity.setControlledMedication(dto.controlledMedication());
        entity.setHasAllergies(dto.hasAllergies());

        // Update rank
        if (dto.rank() != null && dto.rank().id() != null) {
            MilitaryRank rank = militaryRankRepository.findById(dto.rank().id())
                    .orElseThrow(() -> new ResourceNotFoundException("Military Rank", "id", dto.rank().id()));
            entity.setRank(rank);
        }

        // Other relationships would be updated here...
    }

    private MilitaryPeopleDTO convertToDTO(MilitaryPeople entity) {
        if (entity == null) {
            return null;
        }

        // Build MilitaryRankDTO if needed
        MilitaryRankDTO rankDTO = null;
        if (entity.getRank() != null) {
            rankDTO = new MilitaryRankDTO(
                    entity.getRank().getId(),
                    entity.getRank().getNumber(),
                    entity.getRank().getRankAbbreviation(),
                    entity.getRank().getRankName(),
                    entity.getRank().getBranch()
            );
        }

        // Use Builder pattern for the complex DTO
        return MilitaryPeopleDTO.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .warName(entity.getWarName())
                .cpf(entity.getCpf())
                .birthDate(entity.getBirthDate())
                .birthMonth(entity.getBirthMonth())
                .maritalStatus(entity.getMaritalStatus())
                .gender(entity.getGender())
                .religion(entity.getReligion())
                .bloodType(entity.getBloodType())
                .rhFactor(entity.getRhFactor())
                .headSize(entity.getHeadSize())
                .shoeSize(entity.getShoeSize())
                .bootSize(entity.getBootSize())
                .shirtSize(entity.getShirtSize())
                .pantsSize(entity.getPantsSize())
                .shortsSize(entity.getShortsSize())
                .swimwearSize(entity.getSwimwearSize())
                .swimTrunksSize(entity.getSwimTrunksSize())
                .organDonor(entity.getOrganDonor())
                .bloodDonor(entity.getBloodDonor())
                .casMember(entity.getCasMember())
                .sismepeUser(entity.getSismepeUser())
                .hasAccidentCertificate(entity.getHasAccidentCertificate())
                .hasChronicDisease(entity.getHasChronicDisease())
                .controlledMedication(entity.getControlledMedication())
                .hasAllergies(entity.getHasAllergies())
                .rank(rankDTO)
                // Other relationships would be converted here...
                .build();
    }
}