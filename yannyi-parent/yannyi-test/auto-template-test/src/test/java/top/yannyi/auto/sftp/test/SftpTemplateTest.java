package top.yannyi.auto.sftp.test;

import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yannyi.auto.sftp.template.SftpTemplate;

import javax.annotation.Resource;

/**
 * @Author: LeahAna
 * @Date: 2023/5/18 13:15
 * @Desc:
 */


@Slf4j
@SpringBootTest(properties = {"spring.profiles.active=test"})
public class SftpTemplateTest {

    @Resource
    public SftpTemplate sftpTemplate;

    @Test
    public void testGetHome() throws SftpException {
        log.info("testGetHome: {}", sftpTemplate.getHome());
    }
}
