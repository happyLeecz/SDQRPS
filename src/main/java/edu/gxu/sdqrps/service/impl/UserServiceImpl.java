package edu.gxu.sdqrps.service.impl;

import edu.gxu.sdqrps.dao.UserMapper;
import edu.gxu.sdqrps.model.entity.User;
import edu.gxu.sdqrps.model.vo.Result;
import edu.gxu.sdqrps.model.vo.UserDetail;
import edu.gxu.sdqrps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Introspector;
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
    public Result checkUser(String username, String password) {
        Integer id = userMapper.getIdByUserNameAndPassword(username, password);
        if(id == null)
            return new Result<String>(101,"账号或者密码错误");

        User validUser = getUserById(id).get();
        UserDetail returnedInfo = new UserDetail(validUser.getUserId(),validUser.getDescription(),validUser.getLevel());
        return new Result<UserDetail>(100,returnedInfo);


    }

    @Override
    public Optional<User> getUserById(int userId) {
        return Optional.ofNullable(userMapper.getById(userId));
    }
}
