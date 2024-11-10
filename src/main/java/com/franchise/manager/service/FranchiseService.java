package com.franchise.manager.service;

import com.franchise.manager.dto.BranchOfficeDTO;
import com.franchise.manager.dto.FranchiseDTO;
import com.franchise.manager.dto.ProductBranchDTO;
import com.franchise.manager.model.FranchiseModel;

import java.util.List;

public interface FranchiseService {

    FranchiseModel createFranchise(FranchiseDTO franchise);

    FranchiseModel updateFranchiseName(int franchiseId, FranchiseDTO franchise);

    FranchiseModel getFranchiseById(int franchiseId);

    FranchiseModel addBranchOfficeToFranchise(int franchiseId, BranchOfficeDTO branchOffice);

    List<ProductBranchDTO> getTopStockProductsByBranch(int franchiseId);
}
