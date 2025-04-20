package com.guohenry.springbootmall.dao;

import com.guohenry.springbootmall.dto.ProductRequest;
import com.guohenry.springbootmall.model.Product;

public interface ProductDao {

    List<Product> getProducts();

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest prodcutRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
