package com.franchise.manager.service.impl;

import com.franchise.manager.model.FranchiseModel;
import com.franchise.manager.repository.FranchiseRepository;
import com.franchise.manager.service.FrachiseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DefaultFranchiseService implements FrachiseService {

    @Resource
    private FranchiseRepository francheRepository;

    @Override
    public FranchiseModel createFranchise(FranchiseModel franchise) {
        return francheRepository.save(franchise);
    }
}
