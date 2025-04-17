package com.hefti.kd1kturboapi.service;

import com.hefti.kd1kturboapi.dto.MilitaryRankDTO;

import java.util.List;

public interface MilitaryRankService {

    MilitaryRankDTO createRank(MilitaryRankDTO rankDTO);

    MilitaryRankDTO getRankById(Long id);

    List<MilitaryRankDTO> getAllRanks();

    List<MilitaryRankDTO> getRanksByBranch(String branch);

    MilitaryRankDTO updateRank(Long id, MilitaryRankDTO rankDTO);

    void deleteRank(Long id);
}