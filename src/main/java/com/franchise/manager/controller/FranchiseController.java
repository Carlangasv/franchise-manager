package com.franchise.manager.controller;


import com.franchise.manager.dto.FranchiseDTO;
import com.franchise.manager.model.FranchiseModel;
import com.franchise.manager.service.FranchiseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/franchise")
public class FranchiseController extends BaseController<FranchiseModel, FranchiseDTO> {

    @Resource
    private FranchiseService franchiseService;

    @GetMapping("/{id}")
    public FranchiseDTO getFranchiseById(@PathVariable int id) {
        return map(franchiseService.getFranchiseById(id), FranchiseDTO.class);
    }
}
