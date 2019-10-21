package com.tsien.poros.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 11:29
 */

@Data
public class RoleDO {

    /**
    * 主键ID
    */
    private Long roleId;

    /**
    * 角色名称
    */
    private String roleName;

    /**
    * 角色编码
    */
    private String roleCode;

    /**
    * 描述
    */
    private String remark;

    /**
    * 是否删除：（1-删除，0-未删除）
    */
    private Boolean isDeleted;

    /**
    * 创建时间
    */
    private LocalDateTime createTime;

    /**
    * 更新时间
    */
    private LocalDateTime updateTime;
}