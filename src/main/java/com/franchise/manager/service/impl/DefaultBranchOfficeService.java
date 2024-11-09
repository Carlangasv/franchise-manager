package com.franchise.manager.service.impl;

import com.franchise.manager.dto.BranchOfficeDTO;
import com.franchise.manager.exception.ModelNotFoundException;
import com.franchise.manager.model.BranchOfficeModel;
import com.franchise.manager.repository.BranchOfficeRepository;
import com.franchise.manager.service.BranchOfficeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DefaultBranchOfficeService implements BranchOfficeService {

    @Resource
    BranchOfficeRepository branchOfficeRepository;

    @Override
    public BranchOfficeModel getBranchOfficeById(int branchOfficeId) {
        return branchOfficeRepository.findById(branchOfficeId)
                .orElseThrow(() -> new ModelNotFoundException(String.format("Branch office with ID %s not found"
                        , branchOfficeId)));
    }

    @Override
    public BranchOfficeModel createBranchOffice(BranchOfficeDTO branchOffice) {
        BranchOfficeModel branchOfficeModel = new BranchOfficeModel();
        branchOfficeModel.setName(branchOffice.getName());
        branchOfficeRepository.save(branchOfficeModel);
        return branchOfficeModel;
    }

}
