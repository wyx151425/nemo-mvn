package com.rumofuture.nemo.controller;

import com.rumofuture.nemo.model.domain.User;
import com.rumofuture.nemo.model.entity.Response;
import com.rumofuture.nemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户数据 API
 *
 * @author 王振琦  2017/11/30
 */
@RestController
public class UserController extends NemoController {

    @Autowired
    private UserService userService;

    /**
     * 查询漫画作者列表
     *
     * @param index 分页索引
     * @return 响应对象
     */
    @GetMapping(value = "users")
    public Response<List<User>> actionQueryAuthorList(@RequestParam("index") Integer index) {
        List<User> userList = userService.findAuthorList(index);
        return new Response<>(userList);
    }

    /**
     * 更新
     *
     * @param user 用户数据
     * @return 响应对象
     */
    @PutMapping(value = "users")
    public Response<User> actionUpdate(@RequestBody User user) {
        userService.update(user);
        return new Response<>();
    }
}
