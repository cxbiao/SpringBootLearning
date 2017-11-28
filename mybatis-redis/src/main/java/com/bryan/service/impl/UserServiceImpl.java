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
    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserByIdResultMap(int id) {
        return userMapper.findUserByIdResultMap(id);
    }

    @Override
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) {
        return userMapper.findUserList(userQueryVo);
    }

    @Override
    public int findUserListCount(UserQueryVo userQueryVo) {
        return userMapper.findUserListCount(userQueryVo);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Transactional
    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
