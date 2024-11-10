package com.franchise.manager.controller;


import com.franchise.manager.dto.BranchOfficeDTO;
import com.franchise.manager.dto.FranchiseDTO;
import com.franchise.manager.dto.ProductBranchDTO;
import com.franchise.manager.model.FranchiseModel;
import com.franchise.manager.service.FranchiseService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/franchise")
public class FranchiseController extends BaseController<FranchiseModel, FranchiseDTO> {

    @Resource
    private FranchiseService franchiseService;

    @GetMapping("/{franchiseId}")
    public FranchiseDTO getFranchiseById(@PathVariable int franchiseId) {
        return map(franchiseService.getFranchiseById(franchiseId), FranchiseDTO.class);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public FranchiseDTO createFranchise(@RequestBody FranchiseDTO franchiseDTO) {
        return map(franchiseService.createFranchise(franchiseDTO), FranchiseDTO.class);
    }

    @PatchMapping("/{franchiseId}/name")
    public FranchiseDTO updateFranchiseName(@PathVariable int franchiseId, @RequestBody FranchiseDTO franchiseDTO) {
        return map(franchiseService.updateFranchiseName(franchiseId, franchiseDTO), FranchiseDTO.class);
    }

    @PostMapping("/{franchiseId}/branches")
    public FranchiseDTO addBranchToFranchise(@PathVariable int franchiseId, @RequestBody BranchOfficeDTO branch) {
        return map(franchiseService.addBranchOfficeToFranchise(franchiseId, branch), FranchiseDTO.class);
    }

    @GetMapping("/{franchiseId}/top-stock-products")
    public ResponseEntity<List<ProductBranchDTO>> getTopStockProductsByBranch(@PathVariable int franchiseId) {
        List<ProductBranchDTO> topStockProducts = franchiseService.getTopStockProductsByBranch(franchiseId);
        return ResponseEntity.ok(topStockProducts);
    }
}
