package com.henryg.dao.rowmapper;

import com.henryg.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getInt("productId"));
        product.setProductName(resultSet.getString("productName"));
        product.setCategory(resultSet.getString("category"));
        product.setImageUrl(resultSet.getString("mageUrl"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreateDate(resultSet.getDate("createDate"));
        product.setLastModifiedDate(resultSet.getDate("lastModifiedDate"));

        return product;

    }
}
