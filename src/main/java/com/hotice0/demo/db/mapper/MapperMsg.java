package com.hotice0.demo.db.mapper;

import com.hotice0.demo.db.db_object.DBOMsg;
import com.hotice0.demo.db.db_object.DBOUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author HotIce0
 * @Create 2019-06-13 19:43
 */
@Mapper
@Component
public interface MapperMsg {
    @Select("SELECT * FROM t_msg")
    List<DBOMsg> getAll();

    @Insert("INSERT INTO t_msg (msg, username) VALUES (#{msg}, #{username})")
    int insertMsg(@Param("msg") String msg, @Param("username") String username);

    @Delete("DELETE FROM t_msg WHERE id=#{id}")
    void delMsg(@Param("id") Integer id);
}
