package com.hefti.kd1kturboapi.controller;

import com.hefti.kd1kturboapi.dto.MilitaryRankDTO;
import com.hefti.kd1kturboapi.service.MilitaryRankService;
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
@RequestMapping("/api/v1/ranks")
@Tag(name = "Military Rank", description = "API for managing military ranks")
public class MilitaryRankController {

    @Autowired
    private MilitaryRankService militaryRankService;

    @PostMapping
    @Operation(summary = "Create new military rank", description = "Creates a new military rank record")
    @ApiResponse(responseCode = "201", description = "Military rank created successfully")
    public ResponseEntity<MilitaryRankDTO> createRank(@Valid @RequestBody MilitaryRankDTO rankDTO) {
        MilitaryRankDTO createdRank = militaryRankService.createRank(rankDTO);
        return new ResponseEntity<>(createdRank, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get rank by ID", description = "Returns military rank by its ID")
    @ApiResponse(responseCode = "200", description = "Rank found successfully")
    @ApiResponse(responseCode = "404", description = "Rank not found")
    public ResponseEntity<MilitaryRankDTO> getRankById(@PathVariable Long id) {
        MilitaryRankDTO rankDTO = militaryRankService.getRankById(id);
        return ResponseEntity.ok(rankDTO);
    }

    @GetMapping
    @Operation(summary = "List all ranks", description = "Returns a list of all military ranks")
    @ApiResponse(responseCode = "200", description = "List of ranks returned successfully")
    public ResponseEntity<List<MilitaryRankDTO>> getAllRanks() {
        List<MilitaryRankDTO> ranks = militaryRankService.getAllRanks();
        return ResponseEntity.ok(ranks);
    }

    @GetMapping("/branch/{branch}")
    @Operation(summary = "List ranks by branch", description = "Returns a list of military ranks filtered by branch")
    @ApiResponse(responseCode = "200", description = "Filtered list of ranks returned successfully")
    public ResponseEntity<List<MilitaryRankDTO>> getRanksByBranch(@PathVariable String branch) {
        List<MilitaryRankDTO> ranks = militaryRankService.getRanksByBranch(branch);
        return ResponseEntity.ok(ranks);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update rank", description = "Updates an existing military rank record")
    @ApiResponse(responseCode = "200", description = "Rank updated successfully")
    @ApiResponse(responseCode = "404", description = "Rank not found")
    public ResponseEntity<MilitaryRankDTO> updateRank(@PathVariable Long id, @Valid @RequestBody MilitaryRankDTO rankDTO) {
        MilitaryRankDTO updatedRank = militaryRankService.updateRank(id, rankDTO);
        return ResponseEntity.ok(updatedRank);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete rank", description = "Deletes an existing military rank record")
    @ApiResponse(responseCode = "204", description = "Rank deleted successfully")
    @ApiResponse(responseCode = "404", description = "Rank not found")
    public ResponseEntity<Void> deleteRank(@PathVariable Long id) {
        militaryRankService.deleteRank(id);
        return ResponseEntity.noContent().build();
    }
}