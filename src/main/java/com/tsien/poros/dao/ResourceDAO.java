package com.tsien.poros.dao;

import com.tsien.poros.model.ResourceDO;
import com.tsien.poros.vo.ResourceVO;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据用户ID，查询该用户具备权限的资源树(报错操作按钮)
     *
     * @param userId userId
     * @return resourceVOTree
     */
    List<ResourceVO> listResourceVoTreeByUserId(Long userId);


    /**
     * 根据用户和上级ID查询，这个用户有权限的操作（按钮）资源
     *
     * @param parentId parentId
     * @param userId   userId
     * @return resourceVOList
     */
    List<ResourceVO> listOperationButtonResourcesByParentIdAndUserId(@Param("parentId") Long parentId,
                                                                     @Param("userId") Long userId);
}