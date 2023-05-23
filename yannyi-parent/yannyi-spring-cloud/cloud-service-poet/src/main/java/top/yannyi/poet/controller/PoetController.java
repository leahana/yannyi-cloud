package top.yannyi.poet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.yannyi.feign.api.poet.PoetClient;
import top.yannyi.poet.service.PoetService;

import javax.annotation.Resource;

/**
 * @Author: LeahAna
 * @Date: 2023/5/23 17:01
 * @Desc:
 */

@RestController
@RequestMapping("${yannyi-cloud.yannyi-feign.api.poet-service.name}")
public class PoetController implements PoetClient {

    @Resource
    private PoetService poetService;

    @PostMapping("swagger")
    @Override
    public ResponseEntity<String> getApiModel(MultipartFile multipartFile) {
        try {
            return poetService.getSwaggerApiModel(multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("");
    }
}
