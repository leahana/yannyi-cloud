package top.yannyi.token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: LeahAna
 * @Date: 2023/5/17 10:02
 * @Desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("top.yannyi.feign.api.keycloak")
public class TokenApplication {
    public static void main(String[] args) {
        SpringApplication.run(TokenApplication.class, args);
    }
}
