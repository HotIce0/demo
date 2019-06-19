package com.hotice0.demo.controller;

import com.hotice0.demo.db.db_object.DBOUser;
import com.hotice0.demo.db.mapper.MapperUser;
import com.hotice0.demo.error.DError;
import com.hotice0.demo.error.ErrorCodeMsg;
import com.hotice0.demo.utils.resultUtil.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author HotIce0
 * @Create 2019-05-27 20:26
 */
@RestController
public class IndexController extends BaseController{
    @Autowired
    MapperUser mapperUser;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String index(
            HttpServletRequest request,
            String username,
            String password
    ) {
        // 获取不存在的header会返回null
        System.out.println(request.getHeader("kk"));
        // 获取所有的header的key的值
        List<String> stringListHeaders = Collections.list(request.getHeaderNames());
        for(int i = 0; i < stringListHeaders.size(); i++) {
            System.out.println(stringListHeaders.get(i));
        }

        System.out.println();
        System.out.println(request.getHeader("Content-Type"));
        System.out.println(request.getHeader("ss"));
        System.out.println("通过request获取的参数的值：" + request.getParameter("username"));
        System.out.println("username: " + username);
        return "我";
    }

    /**
     * 登录函数
     * @param request
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(
            HttpServletRequest request,
            String username,
            String password
    ) {
        // 通过用户名查找到其对应密码
        DBOUser dboUser = mapperUser.getUserByUsername(username);

        if (dboUser == null) {
            return Result.fail(DError.USER_INVALIED_USERNAME.getErrCode(), DError.USER_INVALIED_USERNAME.getErrMsg());
        }
        // 验证密码是否正确
        if (dboUser.getPassword().equals(password)){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", username);
            System.out.println(httpSession.getId());
            return Result.success("登录成功");
        } else{
            return Result.fail(DError.USER_PASSWORD_ERROR.getErrCode(), DError.USER_PASSWORD_ERROR.getErrMsg());
        }
    }

    @RequestMapping(value = "/getUsername", method = RequestMethod.POST)
    public String getUsername(
            HttpServletRequest request
    ){
        HttpSession httpSession = request.getSession();
        return (String) httpSession.getAttribute("username");
    }
}
