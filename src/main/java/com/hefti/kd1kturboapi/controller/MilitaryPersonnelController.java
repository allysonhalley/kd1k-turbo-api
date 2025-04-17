package com.hefti.kd1kturboapi.controller;

import com.hefti.kd1kturboapi.dto.MilitaryPersonnelDTO;
import com.hefti.kd1kturboapi.service.MilitaryPersonnelService;
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
@RequestMapping("/api/v1/personnel")
@Tag(name = "Military Personnel", description = "API for managing military personnel")
public class MilitaryPersonnelController {

    private final MilitaryPersonnelService militaryPersonnelService;

    @Autowired
    public MilitaryPersonnelController(MilitaryPersonnelService militaryPersonnelService) {
        this.militaryPersonnelService = militaryPersonnelService;
    }

    @PostMapping
    @Operation(summary = "Create new military personnel", description = "Creates a new military personnel record")
    @ApiResponse(responseCode = "201", description = "Military personnel created successfully")
    public ResponseEntity<MilitaryPersonnelDTO> createPersonnel(@Valid @RequestBody MilitaryPersonnelDTO personnelDTO) {
        MilitaryPersonnelDTO createdPersonnel = militaryPersonnelService.createPersonnel(personnelDTO);
        return new ResponseEntity<>(createdPersonnel, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get personnel by ID", description = "Returns military personnel by their ID")
    @ApiResponse(responseCode = "200", description = "Personnel found successfully")
    @ApiResponse(responseCode = "404", description = "Personnel not found")
    public ResponseEntity<MilitaryPersonnelDTO> getPersonnelById(@PathVariable Long id) {
        MilitaryPersonnelDTO personnelDTO = militaryPersonnelService.getPersonnelById(id);
        return ResponseEntity.ok(personnelDTO);
    }

    @GetMapping("/cpf/{cpf}")
    @Operation(summary = "Get personnel by CPF", description = "Returns military personnel by their CPF")
    @ApiResponse(responseCode = "200", description = "Personnel found successfully")
    @ApiResponse(responseCode = "404", description = "Personnel not found")
    public ResponseEntity<MilitaryPersonnelDTO> getPersonnelByCpf(@PathVariable String cpf) {
        MilitaryPersonnelDTO personnelDTO = militaryPersonnelService.getPersonnelByCpf(cpf);
        return ResponseEntity.ok(personnelDTO);
    }

    @GetMapping
    @Operation(summary = "List all personnel", description = "Returns a list of all military personnel")
    @ApiResponse(responseCode = "200", description = "List of personnel returned successfully")
    public ResponseEntity<List<MilitaryPersonnelDTO>> getAllPersonnel() {
        List<MilitaryPersonnelDTO> personnel = militaryPersonnelService.getAllPersonnel();
        return ResponseEntity.ok(personnel);
    }

    @GetMapping("/rank/{rankId}")
    @Operation(summary = "List personnel by rank", description = "Returns a list of military personnel filtered by rank")
    @ApiResponse(responseCode = "200", description = "Filtered list of personnel returned successfully")
    public ResponseEntity<List<MilitaryPersonnelDTO>> getPersonnelByRank(@PathVariable Long rankId) {
        List<MilitaryPersonnelDTO> personnel = militaryPersonnelService.getPersonnelByRank(rankId);
        return ResponseEntity.ok(personnel);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update personnel", description = "Updates an existing military personnel record")
    @ApiResponse(responseCode = "200", description = "Personnel updated successfully")
    @ApiResponse(responseCode = "404", description = "Personnel not found")
    public ResponseEntity<MilitaryPersonnelDTO> updatePersonnel(@PathVariable Long id, @Valid @RequestBody MilitaryPersonnelDTO personnelDTO) {
        MilitaryPersonnelDTO updatedPersonnel = militaryPersonnelService.updatePersonnel(id, personnelDTO);
        return ResponseEntity.ok(updatedPersonnel);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete personnel", description = "Deletes an existing military personnel record")
    @ApiResponse(responseCode = "204", description = "Personnel deleted successfully")
    @ApiResponse(responseCode = "404", description = "Personnel not found")
    public ResponseEntity<Void> deletePersonnel(@PathVariable Long id) {
        militaryPersonnelService.deletePersonnel(id);
        return ResponseEntity.noContent().build();
    }
}
