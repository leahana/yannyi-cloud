package top.yannyi.feign.api.keycloak;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @Author: LeahAna
 * @Date: 2023/5/17 16:53
 * @Desc:
 */
@FeignClient(name = "${yannyi-cloud.yannyi-feign.api.keycloak-client.name}", url = "${yannyi-cloud.yannyi-feign.api.keycloak-client.url}")
public interface KeycloakClient {

    @GetMapping("admin/realms")
    String getVersionInformation();


    @GetMapping("{realm}/authentication/authenticator-providers")
    String getAuthenticatorProviders(@PathVariable("realm") String realm);

    @PostMapping(value = "realms/{realm-name}/protocol/openid-connect/token",
            consumes = "application/x-www-form-urlencoded")
    Map<String, Object> getToken(@RequestBody MultiValueMap<String, String> map, @PathVariable("realm-name") String realmName);

}
