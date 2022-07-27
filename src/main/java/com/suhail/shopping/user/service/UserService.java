/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.user.service;

import com.suhail.shopping.common.rdo.TokenRdo;
import com.suhail.shopping.user.entity.Permission;
import com.suhail.shopping.user.entity.User;
import com.suhail.shopping.user.qdo.UserCreateQdo;
import com.suhail.shopping.user.qdo.UserLoginQdo;
import com.suhail.shopping.user.qdo.UserPasswordQdo;
import com.suhail.shopping.user.qdo.UserUpdateQdo;
import com.suhail.shopping.user.rdo.UserRdo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {

    @Transactional(readOnly = true)
    User findById(Integer id);

    @Transactional
    User save(User user);

    @Transactional
    TokenRdo createUser(UserCreateQdo userCreateQdo);

    TokenRdo login(UserLoginQdo userLoginQdo);

    @Transactional(readOnly = true)
    User findByUsername(String userName);

    @Transactional(readOnly = true)
    User getUser(Integer userId);

    User findOne(Specification<User> userSpecification);

    @Transactional
    UserRdo update(UserUpdateQdo userUpdateQdo);

    @Transactional
    UserRdo update(UserPasswordQdo userPasswordQdo);

    @Transactional(readOnly = true)
    List<Permission> getUserPermissions(Integer userId);
}
