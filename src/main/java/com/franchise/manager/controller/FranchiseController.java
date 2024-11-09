package com.franchise.manager.controller;


import com.franchise.manager.dto.FranchiseDTO;
import com.franchise.manager.model.FranchiseModel;
import com.franchise.manager.service.FranchiseService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/franchise")
public class FranchiseController extends BaseController<FranchiseModel, FranchiseDTO> {

    @Resource
    private FranchiseService franchiseService;

    @GetMapping("/{id}")
    public FranchiseDTO getFranchiseById(@PathVariable int id) {
        return map(franchiseService.getFranchiseById(id), FranchiseDTO.class);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public FranchiseDTO createFranchise(@Validated @RequestBody FranchiseDTO franchiseModel) {
        return map(franchiseService.createFranchise(franchiseModel), FranchiseDTO.class);
    }
}
