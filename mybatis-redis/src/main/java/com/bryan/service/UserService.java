package com.bryan.service;

import com.bryan.domain.User;
import com.bryan.domain.UserCustom;
import com.bryan.domain.UserQueryVo;

import java.util.List;

public interface UserService {
    User findUserById(int id);

    //使用resultMap进行字段映射
    User findUserByIdResultMap(int id) ;

    //用户综合信息查询
    List<UserCustom> findUserList(UserQueryVo userQueryVo) ;

    int findUserListCount(UserQueryVo userQueryVo) ;


    List<User> findUserByName(String name) ;

    void insertUser(User user);

    void deleteUser(int id) ;

    void updateUser(User user) ;
}
