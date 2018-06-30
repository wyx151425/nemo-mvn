package com.rumofuture.nemo.controller;

import com.rumofuture.nemo.model.domain.User;
import com.rumofuture.nemo.model.entity.Response;
import com.rumofuture.nemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王振琦  2018/02/08
 */
@RestController
public class AccountController extends NemoController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @param user   用户数据传输对象
     * @param result 数据绑定结果对象
     * @return 响应对象
     */
    @PostMapping(value = "users/register")
    public Response<User> actionRegister(@Validated({User.Register.class}) @RequestBody User user, BindingResult result) {
        bindingResultInspect(result);
        userService.register(user);
        return new Response<>(user);
    }

    /**
     * 登录
     *
     * @param requestUser 用户数据传输对象
     * @param result      数据绑定结果对象
     * @return 响应对象
     */
    @PostMapping(value = "users/login")
    public Response<User> actionLogin(@Validated({User.Login.class}) @ModelAttribute User requestUser, BindingResult result) {
        bindingResultInspect(result);
        User user = userService.login(requestUser);
        setHttpSessionUser(user);
        return new Response<>(user);
    }

    /**
     * 退出登录
     *
     * @return 响应对象
     */
    @PostMapping(value = "users/logout")
    public Response<User> actionLogout() {
        removeHttpSessionUser();
        return new Response<>();
    }
}
