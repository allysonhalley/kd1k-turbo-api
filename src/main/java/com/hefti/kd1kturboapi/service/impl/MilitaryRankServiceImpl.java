package com.hefti.kd1kturboapi.service.impl;

import com.hefti.kd1kturboapi.dto.MilitaryRankDTO;
import com.hefti.kd1kturboapi.exception.ResourceNotFoundException;
import com.hefti.kd1kturboapi.model.MilitaryRank;
import com.hefti.kd1kturboapi.repository.MilitaryRankRepository;
import com.hefti.kd1kturboapi.service.MilitaryRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MilitaryRankServiceImpl implements MilitaryRankService {

    private final MilitaryRankRepository militaryRankRepository;

    @Autowired
    public MilitaryRankServiceImpl(MilitaryRankRepository militaryRankRepository) {
        this.militaryRankRepository = militaryRankRepository;
    }

    @Override
    @Transactional
    public MilitaryRankDTO createRank(MilitaryRankDTO rankDTO) {
        // Convert DTO to entity
        MilitaryRank rank = convertToEntity(rankDTO);

        // Save to database
        MilitaryRank savedRank = militaryRankRepository.save(rank);

        // Convert saved entity back to DTO
        return convertToDTO(savedRank);
    }

    @Override
    @Transactional(readOnly = true)
    public MilitaryRankDTO getRankById(Long id) {
        MilitaryRank rank = militaryRankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Military Rank", "id", id));

        return convertToDTO(rank);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MilitaryRankDTO> getAllRanks() {
        List<MilitaryRank> ranks = militaryRankRepository.findAll();

        return ranks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MilitaryRankDTO> getRanksByBranch(String branch) {
        List<MilitaryRank> ranks = militaryRankRepository.findByBranch(branch);

        return ranks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MilitaryRankDTO updateRank(Long id, MilitaryRankDTO rankDTO) {
        // Check if rank exists
        MilitaryRank rank = militaryRankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Military Rank", "id", id));

        // Update entity fields
        rank.setNumber(rankDTO.number());
        rank.setRankAbbreviation(rankDTO.rankAbbreviation());
        rank.setRankName(rankDTO.rankName());
        rank.setBranch(rankDTO.branch());

        // Save changes
        MilitaryRank updatedRank = militaryRankRepository.save(rank);

        // Convert updated entity to DTO
        return convertToDTO(updatedRank);
    }

    @Override
    @Transactional
    public void deleteRank(Long id) {
        // Check if rank exists
        MilitaryRank rank = militaryRankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Military Rank", "id", id));

        // Delete rank
        militaryRankRepository.delete(rank);
    }

    // Helper methods to convert between entity and DTO

    private MilitaryRank convertToEntity(MilitaryRankDTO dto) {
        if (dto == null) {
            return null;
        }

        MilitaryRank rank = new MilitaryRank();
        rank.setId(dto.id());
        rank.setNumber(dto.number());
        rank.setRankAbbreviation(dto.rankAbbreviation());
        rank.setRankName(dto.rankName());
        rank.setBranch(dto.branch());

        return rank;
    }

    private MilitaryRankDTO convertToDTO(MilitaryRank entity) {
        if (entity == null) {
            return null;
        }

        return MilitaryRankDTO.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .rankAbbreviation(entity.getRankAbbreviation())
                .rankName(entity.getRankName())
                .branch(entity.getBranch())
                .build();

    }
}