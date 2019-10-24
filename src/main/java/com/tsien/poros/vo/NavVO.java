package com.tsien.poros.vo;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/22 0022 23:57
 */

@Data
public class NavVO {

    /**
     * 主键ID
     */
    private Long resourceId;

    /**
     * 资源的URL地址，要符合前端使用的要求，例如：/：id
     */
    private String resourceUrl;

    /**
     * 请求的方法
     */
    private Object requestMethod;

    /**
     * 前端组件,填写相对路径
     */
    private String componentPath;

    /**
     * 组件名字
     */
    private String componentName;

    /**
     * 上级资源ID
     */
    private Long parentId;

    /**
     * 跳转地址
     */
    private String redirect;

    /**
     * 资源名称，用于前端路由的name字段，不能重复
     */
    private String resourceName;

    /**
     * 资源标题，用户前端Title字段
     */
    private String resourceTitle;

    /**
     * 菜单图标
     */
    private String resourceIcon;

    /**
     * 是否登录后才能访问，供前端使用
     */
    private Boolean requireAuth;

    /**
     * 是否缓存该页面:    1:是   0:不是
     */
    private Boolean keepAlive;

    /**
     * 是否隐藏路由: 0否,1是
     */
    private Boolean hidden;

    /**
     * 菜单打开方式  0-内部打开  1-外部打开
     */
    private Boolean openType;

    /**
     * 菜单排序
     */
    private Double sortNumber;

    /**
     * 下级资源（菜单）
     */
    List<NavVO> children;
}
