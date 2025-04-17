package com.hefti.kd1kturboapi.repository;

import com.hefti.kd1kturboapi.model.MilitaryPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MilitaryPersonnelRepository extends JpaRepository<MilitaryPersonnel, Long> {
    Optional<MilitaryPersonnel> findByCpf(String cpf);

    List<MilitaryPersonnel> findByRankId(Long rankId);

    @Query("SELECT m FROM MilitaryPersonnel m JOIN FETCH m.rank WHERE m.id = :id")
    Optional<MilitaryPersonnel> findByIdWithRank(Long id);
}