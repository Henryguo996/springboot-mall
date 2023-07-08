package com.henryg.service;

import com.henryg.dto.ProductRequest;
import com.henryg.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();


    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
