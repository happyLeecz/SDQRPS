package edu.gxu.sdqrps;

import edu.gxu.sdqrps.dao.UserMapper;
import edu.gxu.sdqrps.model.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class SdqrpsApplicationTests {

    @Autowired
   private UserMapper userMapper;

    @Test
    /**
     * 测试下mybatis
     */
    void mapperTest(){
        User user = userMapper.getByUserName("wxy");
        System.out.println(user.toString());
        Assert.assertEquals(2,user.getUserId());


    }

}
