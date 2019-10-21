package com.tsien.poros.dao;

import com.tsien.poros.model.RoleUserRelationDO;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 11:29
 */

public interface RoleUserRelationDAO {

    int deleteByPrimaryKey(Long id);

    int insert(RoleUserRelationDO record);

    int insertSelective(RoleUserRelationDO record);

    RoleUserRelationDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleUserRelationDO record);

    int updateByPrimaryKey(RoleUserRelationDO record);
}