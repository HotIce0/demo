package com.hotice0.demo.controller;

import com.hotice0.demo.annotation.AnnotationLoginAuth;
import com.hotice0.demo.aspect.AspectLoginAuth;
import com.hotice0.demo.db.mapper.MapperMsg;
import com.hotice0.demo.error.DError;
import com.hotice0.demo.error.DException;
import com.hotice0.demo.service.MsgService;
import com.hotice0.demo.service.MsgServiceInterface;
import com.hotice0.demo.utils.resultUtil.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author HotIce0
 * @Create 2019-06-13 19:41
 */
@RestController
@RequestMapping(value = "/msg")
public class MsgController extends BaseController{
    @Autowired
    MsgServiceInterface msgServiceInterface;


    /**
     * 发布留言
     * @param request
     * @param msg
     * @return
     */
    @AnnotationLoginAuth
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Result leaveMsg(
            HttpServletRequest request,
            @RequestParam
            String msg
    ) throws DException {
        if (msg.length() < 1) {
            throw new DException(DError.SYS_INVALIED_PARAMENT, "留言不能为空");
        }
//            return Result.fail(
//                    DError.SYS_INVALIED_PARAMENT.getErrCode(),
//                    DError.SYS_INVALIED_PARAMENT.setErrMsg("留言不能为空")
//            );

        String username = (String) request.getSession().getAttribute("username");
        msgServiceInterface.addMsg(msg, username);
        return Result.success("成功留言");
    }

    /**
     * 删除留言
     * @param request
     * @param id
     * @return
     */
    @AnnotationLoginAuth
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public Result delMsg(
            HttpServletRequest request,
            @RequestParam
            Integer id
    ) {
        System.out.println(id);
        msgServiceInterface.delMsg(id);
        return Result.success("留言删除成功");
    }
}
