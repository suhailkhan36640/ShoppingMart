/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.user.controller;

import com.suhail.shopping.common.Annotation.CheckPermission;
import com.suhail.shopping.common.Annotation.TokenValidation;
import com.suhail.shopping.common.database.constant.PermissionEnum;
import com.suhail.shopping.common.rdo.BaseRdo;
import com.suhail.shopping.user.entity.User;
import com.suhail.shopping.user.qdo.UserPasswordQdo;
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
@TokenValidation
public class UserRestController {

    @Autowired
    private UserService userService;

    @CheckPermission(PermissionEnum.VIEW_USERS)
    @GetMapping("/{userId}")
    public ResponseEntity<BaseRdo> getUser(@PathVariable Integer userId){
        User user = userService.getUser(userId);
        BaseRdo<UserRdo> response = new BaseRdo<>(new UserRdo(user), new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CheckPermission(PermissionEnum.UPDATE_USERS)
    @PutMapping()
    public ResponseEntity<BaseRdo> update(@RequestBody UserUpdateQdo userUpdateQdo){
        UserRdo userRdo = userService.update(userUpdateQdo);
        BaseRdo<UserRdo> response = new BaseRdo<>(userRdo, new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CheckPermission(PermissionEnum.UPDATE_USERS)
    @PutMapping("/password")
    public ResponseEntity<BaseRdo> password(@RequestBody UserPasswordQdo userPasswordQdo){
        UserRdo userRdo = userService.update(userPasswordQdo);
        BaseRdo<UserRdo> response = new BaseRdo<>(userRdo, new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
