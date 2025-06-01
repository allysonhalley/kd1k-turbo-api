package com.hefti.kd1kturboapi.repository;

import com.hefti.kd1kturboapi.model.MilitaryPeople;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MilitaryPeopleRepository extends JpaRepository<MilitaryPeople, Long> {
    Optional<MilitaryPeople> findByCpf(String cpf);

    List<MilitaryPeople> findByRankId(Long rankId);

    @Query("SELECT m FROM MilitaryPeople m JOIN FETCH m.rank WHERE m.id = :id")
    Optional<MilitaryPeople> findByIdWithRank(Long id);
}