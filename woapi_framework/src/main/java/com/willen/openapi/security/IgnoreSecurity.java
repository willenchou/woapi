package com.willen.openapi.security;

import java.lang.annotation.*;

/**
 * 忽略安全性检查
 *
 * @author willen
 *
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreSecurity {
}
