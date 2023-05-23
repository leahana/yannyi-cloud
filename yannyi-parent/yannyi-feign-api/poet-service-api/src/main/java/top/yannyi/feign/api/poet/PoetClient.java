package top.yannyi.feign.api.poet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: LeahAna
 * @Date: 2023/5/23 17:06
 * @Desc:
 */

@FeignClient(name = "${yannyi-cloud.yannyi-feign.api.poet-service.name}")
@RequestMapping("${yannyi-cloud.yannyi-feign.api.poet-service.name}")
public interface PoetClient {
    @PostMapping("swagger")
    ResponseEntity<String> getApiModel(MultipartFile multipartFile);
}
