package com.henryg.dao;

import com.henryg.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
