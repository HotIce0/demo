package com.hotice0.demo.controller;

import com.hotice0.demo.annotation.AnnotationLoginAuth;
import com.hotice0.demo.aspect.AspectLoginAuth;
import com.hotice0.demo.db.mapper.MapperMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author HotIce0
 * @Create 2019-06-13 19:41
 */
@RestController
@RequestMapping(value = "/msg")
public class MsgController {
    @Autowired
    MapperMsg mapperMsg;


    // 加了AnnotationLoginAuth注解，则会进行登录认证
    @AnnotationLoginAuth
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String leaveMsg(
            HttpServletRequest request,
            String msg) {
        System.out.println("调用了 leaveMsg 函数");
        if (msg.length() < 1) {
            return "留言不能为空";
        }
        String username = (String) request.getSession().getAttribute("username");
        mapperMsg.insertMsg(msg, username);
        return "成功插入留言";
    }
}
