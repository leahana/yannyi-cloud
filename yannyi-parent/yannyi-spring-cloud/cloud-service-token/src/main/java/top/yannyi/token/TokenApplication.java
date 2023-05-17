package top.yannyi.token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: LeahAna
 * @Date: 2023/5/17 10:02
 * @Desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TokenApplication {
    public static void main(String[] args) {
        SpringApplication.run(TokenApplication.class, args);
    }
}
