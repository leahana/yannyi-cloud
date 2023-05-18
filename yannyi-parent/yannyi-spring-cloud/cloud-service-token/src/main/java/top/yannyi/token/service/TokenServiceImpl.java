package top.yannyi.token.service;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import top.yannyi.feign.api.keycloak.KeycloakClient;

import javax.annotation.Resource;

/**
 * @Author: LeahAna
 * @Date: 2023/5/17 16:59
 * @Desc:
 */

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String getToken() {
        return "this is token";
    }
}
