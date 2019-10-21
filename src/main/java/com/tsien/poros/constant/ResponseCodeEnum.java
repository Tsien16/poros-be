package com.tsien.poros.constant;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/9/24 0024 9:54
 */

public enum ResponseCodeEnum {

    /**
     * 0=成功
     */
    SUCCESS("success"),

    /**
     * 1=错误
     */
    ERROR("error"),

    /**
     * 2=参数错误
     */
    ILLEGAL_ARGUMENT("ILLEGAL_ARGUMENT"),

    /**
     * 10=需要登陆
     */
    NEED_LOGIN("NEED_LOGIN");

    private final String status;

    ResponseCodeEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
