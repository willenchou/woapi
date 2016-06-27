package com.willen.woapi.login;

import org.springframework.stereotype.Service;

/**
 * 用户服务
 *
 * @author willen
 *
 */
@Service
public class UserService {

    public boolean login(String username, String password) {
        // TODO
        return username.equals(password);
    }
}
