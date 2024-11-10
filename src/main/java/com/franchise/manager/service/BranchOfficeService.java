package com.franchise.manager.service;

import com.franchise.manager.dto.BranchOfficeDTO;
import com.franchise.manager.dto.ProductDTO;
import com.franchise.manager.model.BranchOfficeModel;

public interface BranchOfficeService {

    BranchOfficeModel getBranchOfficeById(int branchOfficeId);

    BranchOfficeModel createBranchOffice(BranchOfficeDTO branchOffice);

    BranchOfficeModel updateBranchOfficeName(int branchOfficeId, BranchOfficeDTO branchOffice);

    BranchOfficeModel addProductToBranchOffice(int branchOfficeId, ProductDTO product);

    BranchOfficeModel removeProductFromBranchOffice(int branchOfficeId, int productId);

    BranchOfficeModel updateStockAmountForProductInBranchOffice(int branchOfficeId, ProductDTO product);

    BranchOfficeModel updateNameForProductInBranchOffice(int branchOfficeId, ProductDTO product);
}
