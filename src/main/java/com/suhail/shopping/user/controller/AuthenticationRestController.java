/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.user.controller;

import com.suhail.shopping.common.rdo.BaseRdo;
import com.suhail.shopping.user.entity.User;
import com.suhail.shopping.user.qdo.UserCreateQdo;
import com.suhail.shopping.user.qdo.UserLoginQdo;
import com.suhail.shopping.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class AuthenticationRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<BaseRdo> signUp(@RequestBody UserCreateQdo userCreateQdo) {
        User user = userService.createUser(userCreateQdo);
        BaseRdo<User> response = new BaseRdo<>(user, new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<BaseRdo> login(@RequestBody UserLoginQdo userLoginQdo){
        Boolean login = userService.login(userLoginQdo);
        BaseRdo<Boolean> response = new BaseRdo<>(login, new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

}
