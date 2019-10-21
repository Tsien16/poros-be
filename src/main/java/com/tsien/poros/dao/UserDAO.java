package com.tsien.poros.dao;

import com.tsien.poros.model.UserDO;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 11:29
 */

public interface UserDAO {

    int deleteByPrimaryKey(Long userId);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    /**
     * 根据用户名查询用户
     *
     * @param username username
     * @return User
     */
    UserDO getUserByUsername(String username);
}