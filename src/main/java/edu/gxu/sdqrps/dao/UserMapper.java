package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author cz
 */

public interface UserMapper {

    User getByUserName(@Param("userName") String userName);


}
