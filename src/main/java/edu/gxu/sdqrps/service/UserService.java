package edu.gxu.sdqrps.service;

import edu.gxu.sdqrps.model.entity.User;
import edu.gxu.sdqrps.model.vo.InfoResult;

import java.util.Optional;

/**
 * @author cz
 * @date 2019/11/27 2:32 PM
 */
public interface UserService {
    /**
     * check if the login information is correct
     * @param username
     * @param password
     * @return true if the login information is correct;
     *         false otherwise
     */
    InfoResult checkUser(String username, String password);

    /**
     * get User detail
     * this method must be executed after checkUser() method returns true
     * @param userName
     * @return Optional<User> object
     */
    Optional<User> getUserById(int userId);

    InfoResult getAllUserDes();
}
