package com.guohenry.springbootmall.dao.impl;

import com.guohenry.springbootmall.dao.ProductDao;
import com.guohenry.springbootmall.dto.ProductRequest;
import com.guohenry.springbootmall.model.Product;
import com.guohenry.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId){
        String sql ="SELECT product_id,product_name, category, image_url, price, stock, description, created_date, last_modified_date FROM product WHERE product_id = :productId";
    Map<String, Object> map = new HashMap<>();
    map.put("productId", productId);

    List<Product> productList = namedParameterJdbcTemplate.query(sql,map, new ProductRowMapper());

     if(productList.size() > 0){
         return productList.get(0);
     }else{
         return null;
     }

    }


    @Override
    public Integer createProduct(ProductRequest prodcutRequest) {
        String sql = "INSERT INTO product((product_name, category, image_url, price, stock," +
                " description, created_date, last_modified_date) " +
                "VALUES (:productName,:category, : imageUrl, :price, :stock, : description," +
                " :createDate, :lastModifiedDate)";
        Map<String ,Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", prodcutRequest.getCategory());
        map.put("imageUrl", prodcutRequest.getImageUrl());
        map.put("price", prodcutRequest.getPrice());
        map.put("stock", prodcutRequest.getStock());
        map.put("description", prodcutRequest.getDescription());

        Date now = new Date();
        map.put("createDate",now);
        map.put("lastModifiedDate",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map) , keyHolder);

        int productId =  keyHolder.getKey().intValue();

        return productId;
    }

}
