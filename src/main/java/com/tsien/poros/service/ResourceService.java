package com.tsien.poros.service;

import com.tsien.poros.model.ResourceDO;
import com.tsien.poros.vo.NavVO;
import com.tsien.poros.vo.PermissionVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 14:44
 */

public interface ResourceService {

    /**
     * 查询所有资源
     *
     * @return resources
     */
    List<ResourceDO> listResources();

    /**
     * 通过userId查询个人的所有菜单（不包含按钮）
     *
     * @param userId userId
     * @return NavVOList
     */
    List<NavVO> listNavByUserId(Long userId);

    /**
     * 根据用户ID查询，这个用户有权限的操作（按钮）资源
     *
     * @param userId   userId
     * @return PermissionVOList
     */
    List<PermissionVO> listPermissionsByUserId(Long userId);
}
