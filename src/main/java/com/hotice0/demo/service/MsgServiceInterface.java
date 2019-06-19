package com.hotice0.demo.service;

import com.hotice0.demo.db.db_object.DBOMsg;
import com.hotice0.demo.error.DException;

import java.util.List;

/**
 * @Author HotIce0
 * @Create 2019-06-19 19:46
 */
public interface MsgServiceInterface {
    void addMsg(String msg, String username) throws DException;
    List<DBOMsg> getAllMsg();
    void delMsg(Integer id);
}
