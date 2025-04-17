package com.hefti.kd1kturboapi.service.impl;

import com.hefti.kd1kturboapi.dto.*;
import com.hefti.kd1kturboapi.exception.ResourceNotFoundException;
import com.hefti.kd1kturboapi.model.*;
import com.hefti.kd1kturboapi.repository.*;
import com.hefti.kd1kturboapi.service.MilitaryPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MilitaryPersonnelServiceImpl implements MilitaryPersonnelService {

    private final MilitaryPersonnelRepository militaryPersonnelRepository;
    private final MilitaryRankRepository militaryRankRepository;

    @Autowired
    public MilitaryPersonnelServiceImpl(MilitaryPersonnelRepository militaryPersonnelRepository,
                                        MilitaryRankRepository militaryRankRepository) {
        this.militaryPersonnelRepository = militaryPersonnelRepository;
        this.militaryRankRepository = militaryRankRepository;
    }

    @Override
    @Transactional
    public MilitaryPersonnelDTO createPersonnel(MilitaryPersonnelDTO personnelDTO) {
        // Convert DTO to entity
        MilitaryPersonnel personnel = convertToEntity(personnelDTO);

        // Save to database
        MilitaryPersonnel savedPersonnel = militaryPersonnelRepository.save(personnel);

        // Convert saved entity back to DTO
        return convertToDTO(savedPersonnel);
    }

    @Override
    @Transactional(readOnly = true)
    public MilitaryPersonnelDTO getPersonnelById(Long id) {
        MilitaryPersonnel personnel = militaryPersonnelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Military Personnel", "id", id));

        return convertToDTO(personnel);
    }

    @Override
    @Transactional(readOnly = true)
    public MilitaryPersonnelDTO getPersonnelByCpf(String cpf) {
        MilitaryPersonnel personnel = militaryPersonnelRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Military Personnel", "cpf", cpf));

        return convertToDTO(personnel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MilitaryPersonnelDTO> getAllPersonnel() {
        List<MilitaryPersonnel> personnelList = militaryPersonnelRepository.findAll();

        return personnelList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MilitaryPersonnelDTO> getPersonnelByRank(Long rankId) {
        List<MilitaryPersonnel> personnelList = militaryPersonnelRepository.findByRankId(rankId);

        return personnelList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MilitaryPersonnelDTO updatePersonnel(Long id, MilitaryPersonnelDTO personnelDTO) {
        // Check if personnel exists
        MilitaryPersonnel personnel = militaryPersonnelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Military Personnel", "id", id));

        // Update entity fields
        updateEntityFields(personnel, personnelDTO);

        // Save changes
        MilitaryPersonnel updatedPersonnel = militaryPersonnelRepository.save(personnel);

        // Convert updated entity to DTO
        return convertToDTO(updatedPersonnel);
    }

    @Override
    @Transactional
    public void deletePersonnel(Long id) {
        // Check if personnel exists
        MilitaryPersonnel personnel = militaryPersonnelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Military Personnel", "id", id));

        // Delete personnel
        militaryPersonnelRepository.delete(personnel);
    }

    // Helper methods to convert between entity and DTO

    private MilitaryPersonnel convertToEntity(MilitaryPersonnelDTO dto) {
        if (dto == null) {
            return null;
        }

        MilitaryPersonnel personnel = new MilitaryPersonnel();

        // Fill basic fields
        personnel.setId(dto.id());
        personnel.setFullName(dto.fullName());
        personnel.setWarName(dto.warName());
        personnel.setCpf(dto.cpf());
        personnel.setBirthDate(dto.birthDate());
        personnel.setBirthMonth(dto.birthMonth());
        personnel.setMaritalStatus(dto.maritalStatus());
        personnel.setGender(dto.gender());
        personnel.setReligion(dto.religion());
        personnel.setBloodType(dto.bloodType());
        personnel.setRhFactor(dto.rhFactor());
        personnel.setHeadSize(dto.headSize());
        personnel.setShoeSize(dto.shoeSize());
        personnel.setBootSize(dto.bootSize());
        personnel.setShirtSize(dto.shirtSize());
        personnel.setPantsSize(dto.pantsSize());
        personnel.setShortsSize(dto.shortsSize());
        personnel.setSwimwearSize(dto.swimwearSize());
        personnel.setSwimTrunksSize(dto.swimTrunksSize());
        personnel.setOrganDonor(dto.organDonor());
        personnel.setBloodDonor(dto.bloodDonor());
        personnel.setCasMember(dto.casMember());
        personnel.setSismepeUser(dto.sismepeUser());
        personnel.setHasAccidentCertificate(dto.hasAccidentCertificate());
        personnel.setHasChronicDisease(dto.hasChronicDisease());
        personnel.setControlledMedication(dto.controlledMedication());
        personnel.setHasAllergies(dto.hasAllergies());

        // Set rank
        if (dto.rank() != null && dto.rank().id() != null) {
            MilitaryRank rank = militaryRankRepository.findById(dto.rank().id())
                    .orElseThrow(() -> new ResourceNotFoundException("Military Rank", "id", dto.rank().id()));
            personnel.setRank(rank);
        }

        // Other relationships would be configured here...

        return personnel;
    }

    private void updateEntityFields(MilitaryPersonnel entity, MilitaryPersonnelDTO dto) {
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

    private MilitaryPersonnelDTO convertToDTO(MilitaryPersonnel entity) {
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
        return MilitaryPersonnelDTO.builder()
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