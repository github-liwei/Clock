package com.liwei.common.annotation;

import java.lang.annotation.*;

/**
 * app登录效验
 *
 * @author chenshun
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
