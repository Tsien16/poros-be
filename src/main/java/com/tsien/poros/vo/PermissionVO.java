package com.tsien.poros.vo;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/23 0023 23:37
 */

@Data
public class PermissionVO {

    /**
     * 主键ID
     */
    private Long permissionId;

    /**
     * 上级资源ID
     */
    private Long parentId;

    /**
     * 资源标题，用户前端Title字段
     */
    private String permissionTitle;

    /**
     * 操作权限
     */
    List<ActionVO> actions;

}
