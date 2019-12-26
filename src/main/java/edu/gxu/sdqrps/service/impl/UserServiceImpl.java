package edu.gxu.sdqrps.service.impl;

import edu.gxu.sdqrps.dao.UserMapper;
import edu.gxu.sdqrps.model.entity.User;
import edu.gxu.sdqrps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author cz
 * @date 2019/11/27 6:09 PM
 */
@Service
public class UserServiceImpl implements UserService {

    private  UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean checkUser(String username, String password) {
        User toCheck = userMapper.getByUserName(username);
       return toCheck != null && password.equals(toCheck.getPassword());

    }

    @Override
    public Optional<User> getUser(String userName) {
        return Optional.of(userMapper.getByUserName(userName));
    }
}
