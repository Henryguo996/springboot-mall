package com.guohenry.springbootmall.service;

import com.guohenry.springbootmall.dto.UserRegisterRequest;
import com.guohenry.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);
}
