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
import com.suhail.shopping.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public User createUser(UserCreateQdo userCreateQdo) {
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
        return save(user);
    }

    @Override
    public Boolean login(UserLoginQdo userLoginQdo) {
        User user1 = findByUsername(userLoginQdo.getUserName());
        if(user1 == null) return false;
        if(user1.getPassword().equals(user1.getPassword())) return true;
        return false;
    }


    @Override
    public User findByUsername(String userName) {
//        Specification<User> userSpecification = (((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), userName)));
//        return findOne(userSpecification);
        return userRepository.findByUserName(userName);
    }


    @Override
    public User findOne(Specification<User> userSpecification) {
        return userRepository.findOne(userSpecification).orElse(null);
    }
}
