package com.hefti.kd1kturboapi.service;

import com.hefti.kd1kturboapi.dto.MilitaryPeopleDTO;

import java.util.List;

public interface MilitaryPeopleService {

    MilitaryPeopleDTO createPeople(MilitaryPeopleDTO peopleDTO);

    MilitaryPeopleDTO getPeopleById(Long id);

    MilitaryPeopleDTO getPeopleByCpf(String cpf);

    List<MilitaryPeopleDTO> getAllPeople();

    List<MilitaryPeopleDTO> getPeopleByRank(Long rankId);

    MilitaryPeopleDTO updatePeople(Long id, MilitaryPeopleDTO peopleDTO);

    void deletePeople(Long id);
}