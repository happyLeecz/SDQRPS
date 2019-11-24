package edu.gxu.sdqrps.dao;

import edu.gxu.sdqrps.model.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author cz
 */
public interface UserMapper {

    User getByUserName(@Param("userName") String userName);


}
