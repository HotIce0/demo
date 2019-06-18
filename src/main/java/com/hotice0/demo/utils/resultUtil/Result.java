package com.hotice0.demo.utils.resultUtil;

import com.hotice0.demo.error.DError;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HotIce0
 * @Create 2019-06-17 21:09
 */
@Data
public class Result {
    private String status;
    private Object data;

    /**
     * 构造一个成功时返回的结果对象
     * @param data
     * @return
     */
    static public Result success(Object data) {
        Result result = new Result();
        result.setStatus("success");
        result.setData(data);
        return result;
    }

    /**
     * 构造一个失败时返回的结果对象
     * @param errCode
     * @param errMsg
     * @return
     */
    static public Result fail(Integer errCode, String errMsg) {
        Result result = new Result();
        result.setStatus("fail");
        Map<String, Object> errMap = new HashMap<>();
        errMap.put("errCode", errCode);
        errMap.put("errMsg", errMsg);
        result.setData(errMap);
        return result;
    }
}