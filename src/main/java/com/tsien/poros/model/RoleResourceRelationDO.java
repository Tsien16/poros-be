package com.tsien.poros.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 11:29
 */

@Data
public class RoleResourceRelationDO {

    /**
    * 主键ID
    */
    private Long id;

    /**
    * 角色ID
    */
    private Long roleId;

    /**
    * 资源ID
    */
    private Long resourceId;
}