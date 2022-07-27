/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.common.interceptor;

import com.suhail.shopping.common.Annotation.CheckPermission;
import com.suhail.shopping.common.Annotation.TokenValidation;
import com.suhail.shopping.common.authentication.UserDetail;
import com.suhail.shopping.common.database.constant.PermissionEnum;
import com.suhail.shopping.common.exception.PermissionDeniedException;
import com.suhail.shopping.user.entity.Permission;
import com.suhail.shopping.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

@Component
public class PermissionInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserDetail userDetail;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("PermissionInterceptor");
        HandlerMethod hm;
        try {
            hm = (HandlerMethod) handler;
        } catch (ClassCastException e) {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        Method method = hm.getMethod();
        if(method.isAnnotationPresent(CheckPermission.class)){
            CheckPermission userPermission = method.getAnnotation(CheckPermission.class);
            PermissionEnum permissionEnum = userPermission.value();
            Integer userId = userDetail.getId(); // from session
            List<Permission> permissionList = userService.getUserPermissions(userId);
            for(Permission permission: permissionList) {
                if(permission.getValue().equals(permissionEnum.toString())) {
                    return true;
                }
            }
            throw new PermissionDeniedException("Permission Denied");
        }
        return true;
    }
}
