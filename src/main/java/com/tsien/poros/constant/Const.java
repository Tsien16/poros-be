package com.tsien.poros.constant;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/20 0020 12:36
 */

public interface Const {

    /**
     * 表单登录地址
     */
    String LOGIN_PROCESSING_URL = "/auth/login";

    /**
     * 注销地址
     */
    String LOGOUT_PROCESSING_URL = "/auth/logout";

    /**
     * 自定义权限名称，需要登录
     */
    String ROLE_LOGIN = "ROLE_LOGIN";

    /**
     * 问号
     */
    String QUESTION_MARK = "?";
}
