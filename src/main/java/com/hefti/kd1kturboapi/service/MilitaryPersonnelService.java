package com.hefti.kd1kturboapi.service;

import com.hefti.kd1kturboapi.dto.MilitaryPersonnelDTO;

import java.util.List;

public interface MilitaryPersonnelService {

    MilitaryPersonnelDTO createPersonnel(MilitaryPersonnelDTO personnelDTO);

    MilitaryPersonnelDTO getPersonnelById(Long id);

    MilitaryPersonnelDTO getPersonnelByCpf(String cpf);

    List<MilitaryPersonnelDTO> getAllPersonnel();

    List<MilitaryPersonnelDTO> getPersonnelByRank(Long rankId);

    MilitaryPersonnelDTO updatePersonnel(Long id, MilitaryPersonnelDTO personnelDTO);

    void deletePersonnel(Long id);
}