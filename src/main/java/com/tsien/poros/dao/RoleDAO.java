package com.tsien.poros.dao;

import com.tsien.poros.model.RoleDO;
import com.tsien.poros.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 11:29
 */

public interface RoleDAO {

    int deleteByPrimaryKey(Long roleId);

    int insert(RoleDO record);

    int insertSelective(RoleDO record);

    RoleDO selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(RoleDO record);

    int updateByPrimaryKey(RoleDO record);

    /**
     * 根据用户ID查询关联的角色
     *
     * @param userId userId
     * @return roles
     */
    List<RoleDO> listRolesByUserId(Long userId);

    /**
     * 根据资源ID查询关联的角色
     *
     * @param resourceId resourceId
     * @return roles
     */
    List<RoleDO> listRolesByResourceId(Long resourceId);

    /**
     * 根据resourceUrl和requestMethod，查询这个资源关联的角色
     *
     * @param resourceUrl   resourceUrl
     * @param requestMethod requestMethod
     * @return roleVos
     */
    List<RoleVO> listRolesByResourceUrlAndRequestMethod(@Param("resourceUrl") String resourceUrl,
                                                        @Param("requestMethod") String requestMethod);
}