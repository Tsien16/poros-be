package com.tsien.poros.vo;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 16:38
 */

@Data
public class UserVO {

    /**
     * 主键ID
     */
    private Long userId;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 头像
     */
    private String profilePicture;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 性别(0-默认未知,1-男,2-女)
     */
    private Integer gender;

    /**
     * 移动电话
     */
    private String mobilePhone;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 工号，唯一键
     */
    private String workNumber;

    /**
     * 职位ID,关联职位表
     */
    private Long positionId;

    /**
     * 用户角色
     */
    private List<RoleVO> roles;


}
