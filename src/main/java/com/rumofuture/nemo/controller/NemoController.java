package com.rumofuture.nemo.controller;

import com.rumofuture.nemo.context.exception.NemoException;
import com.rumofuture.nemo.model.domain.User;
import com.rumofuture.nemo.util.constant.NemoConst;
import com.rumofuture.nemo.util.constant.RespStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 控制器基类
 *
 * @author 王振琦  2017/12/25
 */
public class NemoController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    public HttpServletRequest getHttpServletRequest() {
        return request;
    }

    public HttpSession getHttpSession() {
        return session;
    }

    public void setHttpSessionUser(User user) {
        session.setAttribute(NemoConst.USER, user);
    }

    public User getHttpSessionUser() {
        return (User) session.getAttribute(NemoConst.USER);
    }

    public void removeHttpSessionUser() {
        session.setAttribute(NemoConst.USER, null);
    }

    void bindingResultInspect(BindingResult result) {
        if (result.hasErrors()) {
            throw new NemoException(RespStatus.PARAM_ERROR);
        }
    }
}
