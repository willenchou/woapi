package com.willen.openapi.security;

/**
 * 令牌管理器
 *
  * @author willen
 *
 */
public interface TokenManager {

    String createToken(String username);

    boolean checkToken(String token);
}
