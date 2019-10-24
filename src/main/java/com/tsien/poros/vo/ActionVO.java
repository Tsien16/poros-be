package com.tsien.poros.vo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/24 0024 9:33
 */

@Data
public class ActionVO {

    /**
     * 主键ID
     */
    private Long actionId;

    /**
     * 资源的URL地址，要符合前端使用的要求，例如：/：id
     */
    private String actionUrl;

    /**
     * 请求的方法
     */
    private Object actionMethod;

    /**
     * 上级资源ID
     */
    private Long parentId;

    /**
     * 跳转地址
     */
    private String redirect;

    /**
     * 资源标题，用户前端Title字段
     */
    private String actionTitle;

    /**
     * 菜单图标
     */
    private String actionIcon;

    /**
     * 备注
     */
    private String remark;
}
