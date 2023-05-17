package top.yannyi.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yannyi.feign.api.HelloClient;

/**
 * @Author: LeahAna
 * @Date: 2023/5/16 17:51
 * @Desc:
 */

@RestController
@RequestMapping("/hello")
public class HelloController implements HelloClient {
    @GetMapping
    @Override
    public String hello() {
        return "hello helloClient";
    }
}
