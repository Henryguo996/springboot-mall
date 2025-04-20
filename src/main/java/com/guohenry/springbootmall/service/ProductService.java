package com.guohenry.springbootmall.service;

import com.guohenry.springbootmall.dto.ProductRequest;
import com.guohenry.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
