package top.yannyi.feign.api.token;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LeahAna
 * @Date: 2023/5/16 17:42
 * @Desc:
 */

@FeignClient(name = "${yannyi-cloud.yannyi-feign.api.token-client.name}")
public interface TokenClient {
    @GetMapping
     String getToken();

}
