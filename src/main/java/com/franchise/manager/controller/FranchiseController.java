package com.franchise.manager.controller;


import com.franchise.manager.model.FranchiseModel;
import com.franchise.manager.service.FranchiseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/franchise")
public class FranchiseController {

    @Resource
    private FranchiseService franchiseService;

    @GetMapping("/{id}")
    public FranchiseModel getFranchiseById(@PathVariable int id) {
        return franchiseService.getFranchiseById(id);
    }
}
