package com.tsien.poros.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 11:29
 */

@Data
public class ResourceDO {

    /**
     * 主键ID
     */
    private Long resourceId;

    /**
     * URL鉴权匹配规则，用于AntPathMatcher与请求的URL进行匹配、鉴权
     */
    private String resourceMatchingRule;

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
     * 菜单类型(1:一级菜单  2:二级菜单 9:操作（按钮）权限)
     */
    private Boolean resourceType;

    /**
     * 是否路由菜单: 0:不是  1:是（默认值1）
     */
    private Boolean route;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否生效 1-正常 0-未生效
     */
    private Boolean enabled;

    /**
     * 是否删除 1-删除 0-未删除
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 资源关联的角色
     */
    List<RoleDO> roles;
}