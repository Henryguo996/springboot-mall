package com.henryg.service;

import com.henryg.dto.ProductRequest;
import com.henryg.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
