package com.oak.sysbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(exclude = JdbcRepositoriesAutoConfiguration.class)
@EnableFeignClients
public class SysbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysbaseApplication.class, args);
    }

}
