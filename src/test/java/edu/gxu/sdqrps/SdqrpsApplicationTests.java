package edu.gxu.sdqrps;

import edu.gxu.sdqrps.dao.DetailMapper;
import edu.gxu.sdqrps.dao.UserMapper;
import edu.gxu.sdqrps.model.entity.User;
import edu.gxu.sdqrps.model.vo.DetailInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.beans.Introspector;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@SpringBootTest
class SdqrpsApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DetailMapper detailMapper;

    @Test
    /**
     * 测试下mybatis
     */
    void detailmapperTest() {
    List<DetailInfo> infoList= detailMapper.listById(1,1);
        System.out.println(infoList.toString());
    }

}
