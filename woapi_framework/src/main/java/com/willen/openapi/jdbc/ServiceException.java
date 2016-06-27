package com.willen.openapi.jdbc;

/**
 * 服务运行异常
 *
 * @author willen
 *
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
