package com.guohenry.springbootmall.dao;

import com.guohenry.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
