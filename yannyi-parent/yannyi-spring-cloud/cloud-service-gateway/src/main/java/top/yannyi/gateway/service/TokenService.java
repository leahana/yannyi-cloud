package top.yannyi.gateway.service;

import org.springframework.stereotype.Service;
import top.yannyi.feign.api.token.TokenClient;

import javax.annotation.Resource;

/**
 * @Author: LeahAna
 * @Date: 2023/5/17 09:59
 * @Desc:
 */

@Service
public class TokenService {
    @Resource
    private TokenClient tokenClient;

    public String getToken() {
        return tokenClient.getToken();

    }
}
