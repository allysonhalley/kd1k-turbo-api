package com.hefti.kd1kturboapi.controller;

import com.hefti.kd1kturboapi.dto.DependentDTO;
import com.hefti.kd1kturboapi.service.DependentService;
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
@RequestMapping("/api/v1")
@Tag(name = "Dependent", description = "API for managing dependents")
public class DependentController {

    private final DependentService dependentService;

    @Autowired
    public DependentController(DependentService dependentService) {
        this.dependentService = dependentService;
    }

    @PostMapping("/people/{peopleId}/dependents")
    @Operation(summary = "Create new dependent", description = "Creates a new dependent record associated with military people")
    @ApiResponse(responseCode = "201", description = "Dependent created successfully")
    public ResponseEntity<DependentDTO> createDependent(
            @PathVariable Long peopleId,
            @Valid @RequestBody DependentDTO dependentDTO) {
        DependentDTO createdDependent = dependentService.createDependent(peopleId, dependentDTO);
        return new ResponseEntity<>(createdDependent, HttpStatus.CREATED);
    }

    @GetMapping("/dependents/{id}")
    @Operation(summary = "Get dependent by ID", description = "Returns dependent by their ID")
    @ApiResponse(responseCode = "200", description = "Dependent found successfully")
    @ApiResponse(responseCode = "404", description = "Dependent not found")
    public ResponseEntity<DependentDTO> getDependentById(@PathVariable Long id) {
        DependentDTO dependentDTO = dependentService.getDependentById(id);
        return ResponseEntity.ok(dependentDTO);
    }

    @GetMapping("/people/{peopleId}/dependents")
    @Operation(summary = "List dependents by people", description = "Returns a list of dependents of military people")
    @ApiResponse(responseCode = "200", description = "List of dependents returned successfully")
    public ResponseEntity<List<DependentDTO>> getDependentsByPeople(@PathVariable Long peopleId) {
        List<DependentDTO> dependents = dependentService.getDependentsByPeople(peopleId);
        return ResponseEntity.ok(dependents);
    }

    @PutMapping("/dependents/{id}")
    @Operation(summary = "Update dependent", description = "Updates an existing dependent record")
    @ApiResponse(responseCode = "200", description = "Dependent updated successfully")
    @ApiResponse(responseCode = "404", description = "Dependent not found")
    public ResponseEntity<DependentDTO> updateDependent(
            @PathVariable Long id,
            @Valid @RequestBody DependentDTO dependentDTO) {
        DependentDTO updatedDependent = dependentService.updateDependent(id, dependentDTO);
        return ResponseEntity.ok(updatedDependent);
    }

    @DeleteMapping("/dependents/{id}")
    @Operation(summary = "Delete dependent", description = "Deletes an existing dependent record")
    @ApiResponse(responseCode = "204", description = "Dependent deleted successfully")
    @ApiResponse(responseCode = "404", description = "Dependent not found")
    public ResponseEntity<Void> deleteDependent(@PathVariable Long id) {
        dependentService.deleteDependent(id);
        return ResponseEntity.noContent().build();
    }
}