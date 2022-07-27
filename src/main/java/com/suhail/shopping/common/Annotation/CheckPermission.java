/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */
package com.suhail.shopping.common.Annotation;


import com.suhail.shopping.common.database.constant.PermissionEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is used for define permission
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPermission {
    PermissionEnum value();
}
