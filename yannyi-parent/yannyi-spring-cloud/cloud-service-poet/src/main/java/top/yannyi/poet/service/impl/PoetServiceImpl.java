package top.yannyi.poet.service.impl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.yannyi.poet.service.PoetService;
import top.yannyi.util.poet.JavaPoetUtils;

import java.io.InputStream;

/**
 * @Author: LeahAna
 * @Date: 2023/5/23 17:25
 * @Desc:
 */
@Service
public class PoetServiceImpl implements PoetService {


    @Override
    public ResponseEntity<String> getSwaggerApiModel(MultipartFile multipartFile) throws Exception {
        InputStream inputStream = multipartFile.getInputStream();
        String result = JavaPoetUtils.createEntitiesFromXlsx(ApiModel.class, ApiModelProperty.class, "top.yannyi.poet", inputStream);
        return ResponseEntity.ok(result);
    }
}
