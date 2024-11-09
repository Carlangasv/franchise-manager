package com.franchise.manager.service.impl;

import com.franchise.manager.dto.ProductDTO;
import com.franchise.manager.exception.ModelNotFoundException;
import com.franchise.manager.model.ProductModel;
import com.franchise.manager.repository.ProductRepository;
import com.franchise.manager.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DefaultProductService implements ProductService {

    @Resource
    private ProductRepository productRepository;

    @Override
    public ProductModel getProductById(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ModelNotFoundException(String.format("Product %s not found", productId)));
    }

    @Override
    public ProductModel createProduct(ProductDTO product) {
        ProductModel productModel = new ProductModel();
        productModel.setName(product.getName());
        productModel.setStockAmount(product.getStockAmount());
        return productRepository.save(productModel);
    }
}
