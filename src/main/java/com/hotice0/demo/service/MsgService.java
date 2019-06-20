package com.hotice0.demo.service;

import com.hotice0.demo.db.db_object.DBOMsg;
import com.hotice0.demo.db.mapper.MapperMsg;
import com.hotice0.demo.error.DError;
import com.hotice0.demo.error.DException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * @Author HotIce0
 * @Create 2019-06-19 19:47
 */
@Service
public class MsgService implements MsgServiceInterface{
    @Autowired
    MapperMsg mapperMsg;

    @Override
    public void addMsg(String msg, String username) throws DException {
        int affectRows = mapperMsg.insertMsg(msg, username);
        if (affectRows < 1) {
            throw new DException(DError.MSG_ADD_MSG_FAIL_DB);
        }
    }

    @Override
    public List<DBOMsg> getAllMsg() {
        return mapperMsg.getAll();
    }

    @Override
    public void delMsg(Integer id) {
        mapperMsg.delMsg(id);
    }
}
