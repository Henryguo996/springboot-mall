package com.guohenry.springbootmall.service.impl;


import com.guohenry.springbootmall.dao.UserDao;
import com.guohenry.springbootmall.dto.UserRegisterRequest;
import com.guohenry.springbootmall.model.User;
import com.guohenry.springbootmall.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {

        //檢查email
        User user =  userDao.getUserByEmail(userRegisterRequest.getEmail());

         if(user != null){
             log.warn("email {} 已被註冊", userRegisterRequest.getEmail());
             throw new ResponseStatusException(HttpStatus.BAD_Request);
         }

         //創帳號
        return userDao.createUser(userRegisterRequest);
    }
}
