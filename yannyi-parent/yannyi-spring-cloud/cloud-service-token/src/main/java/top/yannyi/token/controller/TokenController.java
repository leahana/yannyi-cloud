package top.yannyi.token.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yannyi.feign.api.token.TokenClient;

/**
 * @Author: LeahAna
 * @Date: 2023/5/17 10:02
 * @Desc:
 */

@RequestMapping("token")
@RestController
public class TokenController implements TokenClient {

    @Override
    @GetMapping
    public String getToken() {
        return "this is token";
    }
}
