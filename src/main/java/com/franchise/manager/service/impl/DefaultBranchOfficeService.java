package com.franchise.manager.service.impl;

import com.franchise.manager.dto.BranchOfficeDTO;
import com.franchise.manager.dto.ProductDTO;
import com.franchise.manager.exception.ModelNotFoundException;
import com.franchise.manager.model.BranchOfficeModel;
import com.franchise.manager.model.ProductModel;
import com.franchise.manager.repository.BranchOfficeRepository;
import com.franchise.manager.service.BranchOfficeService;
import com.franchise.manager.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultBranchOfficeService implements BranchOfficeService {

    @Resource
    private BranchOfficeRepository branchOfficeRepository;

    @Resource
    private ProductService productService;

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

    @Override
    public BranchOfficeModel updateBranchOfficeName(int branchOfficeId, BranchOfficeDTO branchOffice) {
        BranchOfficeModel branchOfficeModel = getBranchOfficeById(branchOfficeId);
        branchOfficeModel.setName(branchOffice.getName());
        return branchOfficeRepository.save(branchOfficeModel);
    }

    @Override
    public BranchOfficeModel addProductToBranchOffice(int branchOfficeId, ProductDTO product) {
        BranchOfficeModel branchOffice = getBranchOfficeById(branchOfficeId);
        ProductModel createdProductModel = productService.createProduct(product);
        createdProductModel.setBranchOffice(branchOffice);
        return branchOfficeRepository.save(branchOffice);
    }

    @Override
    public BranchOfficeModel removeProductFromBranchOffice(int branchOfficeId, int productId) {
        BranchOfficeModel branchOffice = getBranchOfficeById(branchOfficeId);
        ProductModel product = getProductInBranchOffice(productId, branchOffice);
        branchOffice.getProducts().remove(product);
        return branchOfficeRepository.save(branchOffice);
    }


    @Override
    public BranchOfficeModel updateStockAmountForProductInBranchOffice(int branchOfficeId, ProductDTO product) {
        BranchOfficeModel branchOffice = getBranchOfficeById(branchOfficeId);
        ProductModel foundProduct = getProductInBranchOffice(product.getId(), branchOffice);
        foundProduct.setStockAmount(product.getStockAmount());
        return branchOfficeRepository.save(branchOffice);
    }

    @Override
    public BranchOfficeModel updateNameForProductInBranchOffice(int branchOfficeId, ProductDTO product) {
        BranchOfficeModel branchOffice = getBranchOfficeById(branchOfficeId);
        ProductModel foundProduct = getProductInBranchOffice(product.getId(), branchOffice);
        foundProduct.setName(product.getName());
        return branchOfficeRepository.save(branchOffice);
    }

    private ProductModel getProductInBranchOffice(int productId, BranchOfficeModel branchOffice) {
        Optional<ProductModel> product = Optional.ofNullable(productService.getProductById(productId));
        product.filter(branchOffice.getProducts()::contains)
                .orElseThrow(() -> new ModelNotFoundException("Product with ID " + productId + " not found in the branch."));
        return product.get();
    }
}
