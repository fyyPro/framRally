package com.ssm.dao;

import com.ssm.domain.Function;

public interface FunctionDao {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
    
}