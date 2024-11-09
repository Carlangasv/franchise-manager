package com.franchise.manager.service.impl;

import com.franchise.manager.exception.FranchiseNotFoundException;
import com.franchise.manager.model.FranchiseModel;
import com.franchise.manager.repository.FranchiseRepository;
import com.franchise.manager.service.FranchiseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DefaultFranchiseService implements FranchiseService {

    @Resource
    private FranchiseRepository francheRepository;

    @Override
    public FranchiseModel createFranchise(FranchiseModel franchise) {
        return francheRepository.save(franchise);
    }

    @Override
    public FranchiseModel getFranchiseById(int id) {
        return francheRepository.findById(id)
                .orElseThrow(() -> new FranchiseNotFoundException(String.format("Franchise %s not found", id)));
    }
}
