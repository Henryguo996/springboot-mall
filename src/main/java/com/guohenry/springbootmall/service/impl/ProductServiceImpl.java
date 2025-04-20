package com.guohenry.springbootmall.service.impl;

import com.guohenry.springbootmall.dao.ProductDao;
import com.guohenry.springbootmall.model.Product;
import com.guohenry.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId){

        return productDao.getProductById(productId);
    }
}
