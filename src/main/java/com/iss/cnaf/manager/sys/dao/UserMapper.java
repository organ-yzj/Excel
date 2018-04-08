package com.iss.cnaf.manager.sys.dao;

import com.iss.cnaf.manager.sys.mapper.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer autoId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer autoId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}