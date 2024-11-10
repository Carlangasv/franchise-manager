package com.franchise.manager.controller;

import com.franchise.manager.dto.BranchOfficeDTO;
import com.franchise.manager.dto.ProductDTO;
import com.franchise.manager.model.BranchOfficeModel;
import com.franchise.manager.service.BranchOfficeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branchOffice")
public class BranchOfficeController extends BaseController<BranchOfficeModel, BranchOfficeDTO> {

    @Resource
    private BranchOfficeService branchOfficeService;

    @PatchMapping("/{branchOfficeId}/name")
    public BranchOfficeDTO updateBranchOfficeName(@PathVariable int branchOfficeId,
                                                  @RequestBody BranchOfficeDTO branchOfficeDTO) {
        return map(branchOfficeService.updateBranchOfficeName(branchOfficeId, branchOfficeDTO), BranchOfficeDTO.class);
    }

    @PostMapping("/{branchOfficeId}/products")
    public BranchOfficeDTO addProductToBranchOffice(@PathVariable("branchOfficeId") int branchOfficeId,
                                                    @RequestBody ProductDTO productDTO) {
        return map(branchOfficeService.addProductToBranchOffice(branchOfficeId, productDTO), BranchOfficeDTO.class);
    }

    @DeleteMapping("/{branchOfficeId}/products/{productId}")
    public BranchOfficeDTO removeProductFromBranchOffice(@PathVariable("branchOfficeId") int branchOfficeId,
                                                         @PathVariable("productId") int productId) {
        return map(branchOfficeService.removeProductFromBranchOffice(branchOfficeId, productId), BranchOfficeDTO.class);
    }

    @PatchMapping("/{branchOfficeId}/products/stock")
    public BranchOfficeDTO updateProductStockAmountFromBranchOffice(@PathVariable("branchOfficeId") int branchOfficeId,
                                                                    @RequestBody ProductDTO productDTO) {
        return map(branchOfficeService.updateStockAmountForProductInBranchOffice(branchOfficeId, productDTO),
                BranchOfficeDTO.class);
    }

    @PatchMapping("/{branchOfficeId}/products/name")
    public BranchOfficeDTO updateProductNameFromBranchOffice(@PathVariable("branchOfficeId") int branchOfficeId,
                                                             @RequestBody ProductDTO productDTO) {
        return map(branchOfficeService.updateNameForProductInBranchOffice(branchOfficeId, productDTO),
                BranchOfficeDTO.class);
    }
}
