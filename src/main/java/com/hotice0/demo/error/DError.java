package com.hotice0.demo.error;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HotIce0
 * @Create 2019-06-18 20:25
 */
@AllArgsConstructor
public enum DError implements DErrorInterface {
    // 用户模块
    USER_INVALIED_USERNAME(100, "用户名无效"),
    USER_PASSWORD_ERROR(101, "密码错误"),
    // 留言模块

    ;
    private int code;
    private String msg;

    @Override
    public int getErrCode() {
        return code;
    }

    @Override
    public String getErrMsg() {
        return msg;
    }

    @Override
    public String setErrMsg(String errMsg) {
        return errMsg;
    }
}
