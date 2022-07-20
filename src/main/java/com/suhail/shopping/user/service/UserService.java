/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.user.service;

import com.suhail.shopping.user.entity.User;
import com.suhail.shopping.user.qdo.UserCreateQdo;
import com.suhail.shopping.user.qdo.UserLoginQdo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;


public interface UserService {

    @Transactional(readOnly = true)
    User findById(Integer id);

    @Transactional
    User save(User user);

    @Transactional
    User createUser(UserCreateQdo userCreateQdo);

    Boolean login(UserLoginQdo userLoginQdo);

    @Transactional(readOnly = true)
    User findByUsername(String userName);

    User findOne(Specification<User> userSpecification);
}
