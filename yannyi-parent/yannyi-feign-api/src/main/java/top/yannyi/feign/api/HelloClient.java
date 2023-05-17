package top.yannyi.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @Author: LeahAna
 * @Date: 2023/5/16 17:46
 * @Desc:
 */

@FeignClient(name = "${yannyi-cloud.yannyi-feign.api.hello-client.name}")
public interface HelloClient {
    @GetMapping("/hello")
    String hello();
}
