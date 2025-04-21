package com.guohenry.springbootmall.dao;


import com.guohenry.springbootmall.dto.ProductQueryParams;
import com.guohenry.springbootmall.dto.ProductRequest;
import com.guohenry.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest prodcutRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
