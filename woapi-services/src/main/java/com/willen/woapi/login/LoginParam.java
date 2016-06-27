package com.willen.woapi.login;

import com.willen.openapi.validation.NotEmpty;

/**
 * 登录参数对象
 *
 * @author willen
 *
 */
public class LoginParam {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
