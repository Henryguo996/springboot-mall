package com.henryg.service.impl;

import com.henryg.dao.ProductDao;
import com.henryg.model.Product;
import com.henryg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById((productId));
    }
}