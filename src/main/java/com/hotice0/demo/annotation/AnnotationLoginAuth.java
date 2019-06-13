package com.hotice0.demo.annotation;

import java.lang.annotation.*;

/**
 * @Author HotIce0
 * @Create 2019-06-13 20:21
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AnnotationLoginAuth {
}
