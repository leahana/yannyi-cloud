package top.yannyi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: LeahAna
 * @Date: 2023/5/17 09:53
 * @Desc: 网关模块 仅用于请求转发和处理跨域
 */

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
