package com.bryan.service.impl;

import com.bryan.domain.User;
import com.bryan.domain.UserCustom;
import com.bryan.domain.UserQueryVo;
import com.bryan.mapper.UserMapper;
import com.bryan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;
    @Override
    @Transactional(readOnly = true)
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByIdResultMap(int id) {
        return userMapper.findUserByIdResultMap(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) {
        return userMapper.findUserList(userQueryVo);
    }

    @Override
    @Transactional(readOnly = true)
    public int findUserListCount(UserQueryVo userQueryVo) {
        return userMapper.findUserListCount(userQueryVo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertUser(User user) {
       try{
           userMapper.insertUser(user);
          // int i=1/0;
       }catch (Exception ex){
           ex.printStackTrace();
          // 要手动抛出异常 或者这样 setRollbackOnly
           throw  ex;
          // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

       }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
