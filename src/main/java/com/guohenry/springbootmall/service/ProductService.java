package com.guohenry.springbootmall.service;

import com.guohenry.springbootmall.dto.ProductQueryParams;
import com.guohenry.springbootmall.dto.ProductRequest;
import com.guohenry.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);



}
