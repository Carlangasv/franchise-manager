package com.franchise.manager.service.impl;

import com.franchise.manager.dto.FranchiseDTO;
import com.franchise.manager.exception.ModelNotFoundException;
import com.franchise.manager.model.BranchOfficeModel;
import com.franchise.manager.model.FranchiseModel;
import com.franchise.manager.repository.BranchOfficeRepository;
import com.franchise.manager.repository.FranchiseRepository;
import com.franchise.manager.service.FranchiseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFranchiseService implements FranchiseService {

    @Resource
    private FranchiseRepository franchiseRepository;

    @Resource
    private BranchOfficeRepository branchOfficeRepository;

    @Override
    public FranchiseModel createFranchise(FranchiseDTO franchise) {
        FranchiseModel franchiseModel = new FranchiseModel();
        franchiseModel.setName(franchise.getName());
        List<BranchOfficeModel> branchOffices = getBranchOfficesFromFranchise(franchise);
        franchiseModel.setBranchOffices(branchOffices);
        return franchiseRepository.save(franchiseModel);
    }

    private List<BranchOfficeModel> getBranchOfficesFromFranchise(FranchiseDTO franchise) {
        return franchise.getBranchOffices().stream()
                .map(branchOffice -> branchOfficeRepository.findById(branchOffice.getId())
                        .orElseThrow(() -> new ModelNotFoundException(String.format("Branch office with ID %s not found"
                                , branchOffice.getId())))).toList();
    }

    @Override
    public FranchiseModel getFranchiseById(int id) {
        return franchiseRepository.findById(id).orElseThrow(() -> new ModelNotFoundException(String.format("Franchise %s not found", id)));
    }
}
