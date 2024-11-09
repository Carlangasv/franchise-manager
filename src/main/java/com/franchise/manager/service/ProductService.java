package com.franchise.manager.service;

import com.franchise.manager.dto.ProductDTO;
import com.franchise.manager.model.ProductModel;

public interface ProductService {

    ProductModel getProductById(int productId);

    ProductModel createProduct(ProductDTO product);

}
