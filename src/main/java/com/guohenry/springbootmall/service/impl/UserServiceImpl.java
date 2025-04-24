package com.guohenry.springbootmall.service.impl;


import com.guohenry.springbootmall.dao.UserDao;
import com.guohenry.springbootmall.dto.UserLoginRequest;
import com.guohenry.springbootmall.dto.UserRegisterRequest;
import com.guohenry.springbootmall.model.User;
import com.guohenry.springbootmall.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

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
        //使用md5
         String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
         userRegisterRequest.setPassword(hashedPassword);
         //創帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        //檢查user
        if(user == null){
            log.warn("該email {} 未被註冊",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //使用md5
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());

        //比較密碼
        if(user.getPassword().equals(hashedPassword){
            return user;
        }else{
            log.warn("該email {} 的密碼不正確",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
