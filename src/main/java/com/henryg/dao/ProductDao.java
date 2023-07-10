package com.henryg.dao;

import com.henryg.constant.ProductCategory;
import com.henryg.dto.ProductQueryParams;
import com.henryg.dto.ProductRequest;
import com.henryg.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);


    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
