package com.tsien.poros.dao;

import com.tsien.poros.model.ResourceDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 11:29
 */

public interface ResourceDAO {

    int deleteByPrimaryKey(Long resourceId);

    int insert(ResourceDO record);

    int insertSelective(ResourceDO record);

    ResourceDO selectByPrimaryKey(Long resourceId);

    int updateByPrimaryKeySelective(ResourceDO record);

    int updateByPrimaryKey(ResourceDO record);

    /**
     * 查询所有的资源，把Role关联上
     *
     * @return resources
     */
    List<ResourceDO> listResources();
}