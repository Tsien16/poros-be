package com.tsien.poros.dao;

import com.tsien.poros.model.RoleResourceRelationDO;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 11:29
 */

public interface RoleResourceRelationDAO {

    int deleteByPrimaryKey(Long id);

    int insert(RoleResourceRelationDO record);

    int insertSelective(RoleResourceRelationDO record);

    RoleResourceRelationDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleResourceRelationDO record);

    int updateByPrimaryKey(RoleResourceRelationDO record);
}