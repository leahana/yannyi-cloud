package top.yannyi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: LeahAna
 * @Date: 2023/5/17 09:53
 * @Desc:
 */

@SpringBootApplication
@EnableFeignClients(basePackages = "top.yannyi.feign.api.token")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
