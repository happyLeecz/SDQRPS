package edu.gxu.sdqrps.service.impl;

import edu.gxu.sdqrps.dao.UserMapper;
import edu.gxu.sdqrps.model.entity.User;
import edu.gxu.sdqrps.model.vo.InfoResult;
import edu.gxu.sdqrps.model.vo.UserDetail;
import edu.gxu.sdqrps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author cz
 * @date 2019/11/27 6:09 PM
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public InfoResult<?> checkUser(String username, String password) {
        Integer id = userMapper.getIdByUserNameAndPassword(username, password);
        if (id == null)
            return new InfoResult<>(101, "账号或者密码错误");

        User validUser = getUserById(id).get();
        UserDetail userDetail = new UserDetail(validUser.getUserId(), validUser.getDescription(), validUser.getLevel());
        return new InfoResult<>(100, userDetail);


    }

    @Override
    public Optional<User> getUserById(int userId) {
        return Optional.ofNullable(userMapper.getById(userId));
    }

    @Override
    public InfoResult<?> getAllUserDes() {
        return new InfoResult<>(700, userMapper.getAllUser());
    }
}


