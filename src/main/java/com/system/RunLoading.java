package com.system;

import com.service.SystemConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author LinShaoJun
 * @Date 2020/1/20 0:46
 */
@Slf4j
@Component
public class RunLoading implements ApplicationRunner {

    @Autowired
    private SystemConfigService systemConfigService;

    @Override
    public void run(ApplicationArguments args) {
        systemConfigService.refresh();
        log.info("系统配置加载完毕!");
    }
}
