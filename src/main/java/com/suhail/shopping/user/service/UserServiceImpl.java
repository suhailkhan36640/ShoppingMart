/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.user.service;

import com.suhail.shopping.common.authentication.UserDetail;
import com.suhail.shopping.common.exception.InvalidPasswordException;
import com.suhail.shopping.common.exception.InvalidUserNameException;
import com.suhail.shopping.common.rdo.TokenRdo;
import com.suhail.shopping.common.util.JwtUtil;
import com.suhail.shopping.user.entity.Permission;
import com.suhail.shopping.user.entity.User;
import com.suhail.shopping.user.entity.UserType;
import com.suhail.shopping.user.qdo.UserCreateQdo;
import com.suhail.shopping.user.qdo.UserLoginQdo;
import com.suhail.shopping.user.qdo.UserPasswordQdo;
import com.suhail.shopping.user.qdo.UserUpdateQdo;
import com.suhail.shopping.user.rdo.UserRdo;
import com.suhail.shopping.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetail userDetail;

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public TokenRdo createUser(UserCreateQdo userCreateQdo) {
        User user = new User();
        user.setUserName(userCreateQdo.getUserName());
        user.setFirstName(userCreateQdo.getFirstName());
        user.setMiddleName(userCreateQdo.getMiddleName());
        user.setLastName(userCreateQdo.getLastName());
        user.setPassword(userCreateQdo.getPassword());
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        user.setCreatedBy(user);
        user.setUpdatedBy(user);
        UserType userType = new UserType();
        userType.setId(userCreateQdo.getUserType());
        user.setUserType(userType);
        save(user);
        return getTokenRdo(user);
    }

    @Override
    public TokenRdo login(UserLoginQdo userLoginQdo) {
        User user = findByUsername(userLoginQdo.getUserName());
        if(user == null) throw new InvalidUserNameException("Invalid UserName....");
        if(user.getPassword().equals(userLoginQdo.getPassword())) return getTokenRdo(user);
        throw new InvalidPasswordException("Invalid Password....");
    }

    private TokenRdo getTokenRdo(User user) {
        Map<String, Object> claims = new HashMap<>();
        TokenRdo tokenRdo = new TokenRdo();
        String token = jwtUtil.generateToken(Long.valueOf(user.getId()), user.getUserName(), claims);
        tokenRdo.setToken(token);
        tokenRdo.setExpirationTime(jwtUtil.extractExpiration(token));
        return tokenRdo;
    }


    @Override
    public User findByUsername(String userName) {
//        Specification<User> userSpecification = (((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), userName)));
//        return findOne(userSpecification);
        return userRepository.findByUserName(userName);
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }


    @Override
    public User findOne(Specification<User> userSpecification) {
        return userRepository.findOne(userSpecification).orElse(null);
    }

    @Override
    public UserRdo update(UserUpdateQdo userUpdateQdo) {
        Integer id = userDetail.getId();
        User user = findById(id);
        user.setFirstName(userUpdateQdo.getFirstName());
        user.setMiddleName(userUpdateQdo.getMiddleName());
        user.setLastName(userUpdateQdo.getLastName());
        save(user);
        UserRdo userRdo = new UserRdo(user);
        return userRdo;
    }

    @Override
    public UserRdo update(UserPasswordQdo userPasswordQdo) {
        Integer id = userDetail.getId();
        User user = findById(id);
        if (userPasswordQdo.getOldPassword().equals(user.getPassword())) {
            user.setPassword(userPasswordQdo.getNewPassword());
        } else {
            throw new InvalidPasswordException("Old password is incorrect");
        }
        UserRdo userRdo = new UserRdo(user);
        return userRdo;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Permission> getUserPermissions(Integer userId) {
        User user = findById(userId);
        if(user != null && user.getUserType() == null) return new ArrayList<>();
        UserType userType = user.getUserType();
        List<Permission> permissions = userType.getPermissions();
        return permissions;
    }
}
