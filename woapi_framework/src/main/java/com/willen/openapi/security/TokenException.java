package com.willen.openapi.security;

/**
 * 令牌异常
 *
  * @author willen
 *
 */
public class TokenException extends RuntimeException {

    public TokenException(String message) {
        super(message);
    }
}
