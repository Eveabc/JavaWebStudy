package com.ltj.mapper;

import com.ltj.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    @Select("select * from tb_user where id=#{id}")
    User selectById(int i);
//
//    User select(@Param("username") String username, @Param("password") String password);
//
//    User select(Collection collection);
}
