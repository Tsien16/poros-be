package com.tsien.poros.service;

import com.tsien.poros.vo.RoleVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/23 0023 11:47
 */

public interface RoleService {

    /**
     * 根据resourceUrl和requestMethod，查询这个资源关联的角色
     *
     * @param resourceUrl   resourceUrl
     * @param requestMethod requestMethod
     * @return roleVos
     */
    List<RoleVO> listRolesByResourceUrlAndRequestMethod(String resourceUrl, String requestMethod);
}
