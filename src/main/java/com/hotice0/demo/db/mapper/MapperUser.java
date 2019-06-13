package com.hotice0.demo.db.mapper;

import com.hotice0.demo.db.db_object.DBOUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author HotIce0
 * @Create 2019-05-30 20:54
 */
@Mapper
@Component
public interface MapperUser {
    @Select("SELECT * FROM t_user WHERE username=#{username}")
    DBOUser getUserByUsername(
            @Param("username")
            String username
    );
}
