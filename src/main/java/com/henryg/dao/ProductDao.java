package com.henryg.dao;

import com.henryg.dto.ProductRequest;
import com.henryg.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
