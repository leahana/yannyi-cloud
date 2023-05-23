package top.yannyi.poet.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author: LeahAna
 * @Date: 2023/5/23 17:25
 * @Desc:
 */
public interface PoetService {
    ResponseEntity<String> getSwaggerApiModel(MultipartFile multipartFile) throws Exception;
}
