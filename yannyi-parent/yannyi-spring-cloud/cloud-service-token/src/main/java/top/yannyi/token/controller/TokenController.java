package top.yannyi.token.controller;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yannyi.feign.api.token.TokenClient;
import top.yannyi.token.service.TokenService;

import javax.annotation.Resource;

/**
 * @Author: LeahAna
 * @Date: 2023/5/17 10:02
 * @Desc:
 */

@RequestMapping("token")
@RestController
public class TokenController implements TokenClient {

    @Resource
    public TokenService tokenService;

    @Override
    @GetMapping
    public String getToken() {
        return tokenService.getToken();
    }


}
