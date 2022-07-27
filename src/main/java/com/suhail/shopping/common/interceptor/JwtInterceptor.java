/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.common.interceptor;

import com.suhail.shopping.common.Annotation.TokenValidation;
import com.suhail.shopping.common.authentication.UserDetail;
import com.suhail.shopping.common.exception.BadRequestException;
import com.suhail.shopping.common.exception.InvalidTokenException;
import com.suhail.shopping.common.util.JwtUtil;
import com.suhail.shopping.common.util.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.logging.Logger;

@Component
public class JwtInterceptor implements HandlerInterceptor  {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetail userDetail;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        HandlerMethod hm;
        String uri = request.getRequestURI();
        try {
            hm = (HandlerMethod) handler;
        } catch (ClassCastException e) {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        Method method = hm.getMethod();
        if(method.getDeclaringClass().isAnnotationPresent(TokenValidation.class)) {
            String token = request.getHeader(SecurityConstants.HEADER_NAME);
            if(token != null) {
                try {
                    Long id = jwtUtil.extractId(token);
                    userDetail.setId(Math.toIntExact(id));
                } catch (Exception exception) {
                    throw new InvalidTokenException("Invalid Token ....");
                }
            } else {
                throw new BadRequestException("Token is not present ....");
            }
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);

    }
}
