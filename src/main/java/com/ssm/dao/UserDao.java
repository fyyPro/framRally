package com.ssm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.domain.User;

public interface UserDao {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectUser(@Param("name")String name,@Param("password")String password);
    
    List<Map<String,String>> findUserList();
    
    List<Map<String,String>> findUserRoleList();
    
}