package com.guohenry.springbootmall.dao;

import com.guohenry.springbootmall.dto.UserRegisterRequest;
import com.guohenry.springbootmall.model.User;

public interface UserDao {

    User getUserByEmail(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
    Integer createUser(UserRegisterRequest userRegisterRequest);
}
