package com.hotice0.demo.controller;

import com.hotice0.demo.error.DError;
import com.hotice0.demo.error.DException;
import com.hotice0.demo.utils.resultUtil.Result;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author HotIce0
 * @Create 2019-06-19 20:11
 */
public class BaseController {
    /**
     * 统一处理，系统内定义的已知异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = DException.class)
    public Result handleDException(DException e){
        if(e.getErrMsg() == null) {
            return Result.fail(e.getError().getErrCode(), e.getError().getErrMsg());
        } else {
            return Result.fail(e.getError().getErrCode(), e.getErrMsg());
        }
    }

    /**
     * 处理未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        // 记录Exception的消息
        System.out.println(e.getMessage());
        System.out.println(e.getStackTrace());
        return Result.fail(DError.SYS_UNKNOW_ERROR.getErrCode(), DError.SYS_UNKNOW_ERROR.getErrMsg());
    }

    /**
     * 处理@RequestParam抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return Result.fail(DError.SYS_MISSING_PARAMENT.getErrCode(), "缺少参数 : " + e.getParameterName() + " " + e.getParameterType());
    }
}
