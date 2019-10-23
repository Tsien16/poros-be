package com.tsien.poros.service.impl;

import com.tsien.poros.dao.RoleDAO;
import com.tsien.poros.service.RoleService;
import com.tsien.poros.vo.RoleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/23 0023 11:48
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDAO roleDAO;

    /**
     * 根据resourceUrl和requestMethod，查询这个资源关联的角色
     *
     * @param resourceUrl   resourceUrl
     * @param requestMethod requestMethod
     * @return roleVos
     */
    @Override
    public List<RoleVO> listRolesByResourceUrlAndRequestMethod(String resourceUrl, String requestMethod) {
        return roleDAO.listRolesByResourceUrlAndRequestMethod(resourceUrl, requestMethod);
    }
}
