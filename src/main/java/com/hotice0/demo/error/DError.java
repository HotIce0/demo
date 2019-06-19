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
    // 系统模块 100
    SYS_INVALIED_PARAMENT(1001, "无效参数"),
    SYS_UNKNOW_ERROR(1002, "系统未知异常"),
    SYS_MISSING_PARAMENT(1003, "缺少参数"),

    // 用户模块 101
    USER_INVALIED_USERNAME(1011, "用户名无效"),
    USER_PASSWORD_ERROR(1012, "密码错误"),
    // 留言模块 102
    MSG_ADD_MSG_FAIL_DB(1021, "留言失败")

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
