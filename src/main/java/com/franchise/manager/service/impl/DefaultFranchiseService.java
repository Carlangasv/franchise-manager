package com.franchise.manager.service.impl;

import com.franchise.manager.dto.BranchOfficeDTO;
import com.franchise.manager.dto.FranchiseDTO;
import com.franchise.manager.exception.ModelNotFoundException;
import com.franchise.manager.model.BranchOfficeModel;
import com.franchise.manager.model.FranchiseModel;
import com.franchise.manager.repository.FranchiseRepository;
import com.franchise.manager.service.BranchOfficeService;
import com.franchise.manager.service.FranchiseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFranchiseService implements FranchiseService {

    @Resource
    private FranchiseRepository franchiseRepository;

    @Resource
    private BranchOfficeService branchOfficeService;

    @Override
    public FranchiseModel createFranchise(FranchiseDTO franchise) {
        FranchiseModel franchiseModel = new FranchiseModel();
        franchiseModel.setName(franchise.getName());
        List<BranchOfficeModel> branchOffices = getBranchOfficesFromFranchise(franchise);
        franchiseModel.setBranchOffices(branchOffices);
        return franchiseRepository.save(franchiseModel);
    }

    @Override
    public FranchiseModel addBranchOfficeToFranchise(int franchiseId, BranchOfficeDTO branchOffice) {
        FranchiseModel franchise = getFranchiseById(franchiseId);
        BranchOfficeModel createdBranchOfficeModel = branchOfficeService.createBranchOffice(branchOffice);
        createdBranchOfficeModel.setFranchise(franchise);
        return franchiseRepository.save(franchise);
    }

    private List<BranchOfficeModel> getBranchOfficesFromFranchise(FranchiseDTO franchise) {
        return franchise.getBranchOffices().stream()
                .map(branchOffice -> branchOfficeService.getBranchOfficeById(branchOffice.getId()))
                .toList();
    }

    @Override
    public FranchiseModel getFranchiseById(int franchiseId) {
        return franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new ModelNotFoundException(String.format("Franchise %s not found", franchiseId)));
    }
}
