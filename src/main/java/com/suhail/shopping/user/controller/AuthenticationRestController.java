/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.user.controller;

import com.suhail.shopping.common.rdo.BaseRdo;
import com.suhail.shopping.common.rdo.TokenRdo;
import com.suhail.shopping.user.qdo.UserCreateQdo;
import com.suhail.shopping.user.qdo.UserLoginQdo;
import com.suhail.shopping.user.qdo.UserUpdateQdo;
import com.suhail.shopping.user.rdo.UserRdo;
import com.suhail.shopping.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class AuthenticationRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<BaseRdo> signUp(@RequestBody UserCreateQdo userCreateQdo) {
        TokenRdo tokenRdo = userService.createUser(userCreateQdo);
        BaseRdo<TokenRdo> response = new BaseRdo<>(tokenRdo, new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<BaseRdo> login(@RequestBody UserLoginQdo userLoginQdo) {
        TokenRdo tokenRdo = userService.login(userLoginQdo);
        BaseRdo<TokenRdo> response = new BaseRdo<>(tokenRdo, new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
