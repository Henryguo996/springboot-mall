package com.guohenry.springbootmall.rowmapper;

import com.guohenry.springbootmall.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setUserId(resultSet.getInt("user_id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("pasword"));
        user.setCreatedDate(resultSet.getTimestamp("created_date"));
        user.setLastModifiedDat(resultSet.getTimestamp("lastModified_date"));

        return user;
    }
}
