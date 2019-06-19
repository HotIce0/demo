package com.hotice0.demo.error;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author HotIce0
 * @Create 2019-06-19 20:14
 */
@AllArgsConstructor
@Data
public class DException extends Exception{
    private DError error;
    private String errMsg;

    public DException(DError error) {
        this.error = error;
        this.errMsg = null;
    }
}
