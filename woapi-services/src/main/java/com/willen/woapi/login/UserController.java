package com.willen.woapi.login;

import com.willen.openapi.model.Response;
import com.willen.openapi.security.IgnoreSecurity;
import com.willen.openapi.security.TokenManager;
import com.willen.woapi.login.UserBean;
import com.willen.woapi.login.LoginParam;
import com.willen.woapi.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户控制器
 *
 * @author willen
 *
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManager tokenManager;

    /**
     * 登录
     */
    @IgnoreSecurity
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(
        @Valid LoginParam param
    ) {
        // 获取登录信息
        String username = param.getUsername();
        String password = param.getPassword();
        // 调用登录服务
        boolean result = userService.login(username, password);
        if (result) {
            // 创建 token
            String token = tokenManager.createToken(username);
            // 封装 user 对象
            UserBean userBean = new UserBean();
            userBean.setToken(token);
            userBean.setUsername(username);
            // 登录成功，将 user 对象返回前端
            return new Response().success(userBean);
        } else {
            // 登录失败，返回失败信息
            return new Response().failure("login_failure");
        }
    }
}
