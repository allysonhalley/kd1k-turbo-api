package com.hefti.kd1kturboapi.controller;

import com.hefti.kd1kturboapi.dto.MilitaryPeopleDTO;
import com.hefti.kd1kturboapi.service.MilitaryPeopleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@Tag(name = "Military People", description = "API for managing military people")
public class MilitaryPeopleController {

    private final MilitaryPeopleService militaryPeopleService;

    @Autowired
    public MilitaryPeopleController(MilitaryPeopleService militaryPeopleService) {
        this.militaryPeopleService = militaryPeopleService;
    }

    @PostMapping
    @Operation(summary = "Create new military people", description = "Creates a new military people record")
    @ApiResponse(responseCode = "201", description = "Military people created successfully")
    public ResponseEntity<MilitaryPeopleDTO> createPeople(@Valid @RequestBody MilitaryPeopleDTO peopleDTO) {
        MilitaryPeopleDTO createdPeople = militaryPeopleService.createPeople(peopleDTO);
        return new ResponseEntity<>(createdPeople, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get people by ID", description = "Returns military people by their ID")
    @ApiResponse(responseCode = "200", description = "People found successfully")
    @ApiResponse(responseCode = "404", description = "People not found")
    public ResponseEntity<MilitaryPeopleDTO> getPeopleById(@PathVariable Long id) {
        MilitaryPeopleDTO peopleDTO = militaryPeopleService.getPeopleById(id);
        return ResponseEntity.ok(peopleDTO);
    }

    @GetMapping("/cpf/{cpf}")
    @Operation(summary = "Get people by CPF", description = "Returns military people by their CPF")
    @ApiResponse(responseCode = "200", description = "People found successfully")
    @ApiResponse(responseCode = "404", description = "People not found")
    public ResponseEntity<MilitaryPeopleDTO> getPeopleByCpf(@PathVariable String cpf) {
        MilitaryPeopleDTO peopleDTO = militaryPeopleService.getPeopleByCpf(cpf);
        return ResponseEntity.ok(peopleDTO);
    }

    @GetMapping
    @Operation(summary = "List all people", description = "Returns a list of all military people")
    @ApiResponse(responseCode = "200", description = "List of people returned successfully")
    public ResponseEntity<List<MilitaryPeopleDTO>> getAllPeople() {
        List<MilitaryPeopleDTO> people = militaryPeopleService.getAllPeople();
        return ResponseEntity.ok(people);
    }

    @GetMapping("/rank/{rankId}")
    @Operation(summary = "List people by rank", description = "Returns a list of military people filtered by rank")
    @ApiResponse(responseCode = "200", description = "Filtered list of people returned successfully")
    public ResponseEntity<List<MilitaryPeopleDTO>> getPeopleByRank(@PathVariable Long rankId) {
        List<MilitaryPeopleDTO> people = militaryPeopleService.getPeopleByRank(rankId);
        return ResponseEntity.ok(people);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update people", description = "Updates an existing military people record")
    @ApiResponse(responseCode = "200", description = "People updated successfully")
    @ApiResponse(responseCode = "404", description = "People not found")
    public ResponseEntity<MilitaryPeopleDTO> updatePeople(@PathVariable Long id, @Valid @RequestBody MilitaryPeopleDTO peopleDTO) {
        MilitaryPeopleDTO updatedPeople = militaryPeopleService.updatePeople(id, peopleDTO);
        return ResponseEntity.ok(updatedPeople);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete people", description = "Deletes an existing military people record")
    @ApiResponse(responseCode = "204", description = "People deleted successfully")
    @ApiResponse(responseCode = "404", description = "People not found")
    public ResponseEntity<Void> deletePeople(@PathVariable Long id) {
        militaryPeopleService.deletePeople(id);
        return ResponseEntity.noContent().build();
    }
}
