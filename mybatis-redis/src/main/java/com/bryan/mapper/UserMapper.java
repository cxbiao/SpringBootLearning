package com.bryan.mapper;


import com.bryan.domain.User;
import com.bryan.domain.UserCustom;
import com.bryan.domain.UserQueryVo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * mapper接口
 * @author bryan
 * mapper接口规范
 *
 * 1. 在mapper.xml中namespace等于mapper接口地址
 * 2. mapper接口中的方法名和mapper.xml中statement的id一致
 * 3. mapper接口中的方法参数类型和mapper.xml中statement的parameterType一致
 * 4. mapper接口中的方法返回值类型和mapper.xml中statement的resultType一致
 */

public interface UserMapper {

     User findUserById(int id);

     //使用resultMap进行字段映射
      User findUserByIdResultMap(int id) ;

     //用户综合信息查询
      @Cacheable("user")
      List<UserCustom> findUserList(UserQueryVo userQueryVo) ;

      int findUserListCount(UserQueryVo userQueryVo) ;


      List<User> findUserByName(String name) ;

    @CacheEvict(value ="user",allEntries = true)
     void insertUser(User user);

     @CacheEvict(value ="user",allEntries = true)
      void deleteUser(int id) ;

    @CacheEvict(value ="user",allEntries = true)
      void updateUser(User user) ;


}
