package com.hefti.kd1kturboapi.repository;

import com.hefti.kd1kturboapi.model.MilitaryRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MilitaryRankRepository extends JpaRepository<MilitaryRank, Long> {
    Optional<MilitaryRank> findByRankName(String rankName);

    List<MilitaryRank> findByBranch(String branch);
}