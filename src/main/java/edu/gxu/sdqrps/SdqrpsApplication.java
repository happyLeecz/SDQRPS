package edu.gxu.sdqrps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@MapperScan(basePackages = "edu.gxu.sdqrps.dao")
public class SdqrpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdqrpsApplication.class, args);
    }


}
