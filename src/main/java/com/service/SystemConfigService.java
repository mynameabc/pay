package com.service;

import com.auxiliary.constant.ProjectConstant;
import com.pojo.entity.SystemConfig;
import com.mapper.SystemConfigMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Administrator
 */
@Slf4j
@Service
public class SystemConfigService {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private SystemConfigMapper systemConfigMapper;

    @Transactional(rollbackFor = Exception.class)
    public void close(String key) {
        systemConfigMapper.propertiesOpenOrClose(key, ProjectConstant.FAIL);
        getMap().put(key, ProjectConstant.FAIL);
    }

    @Transactional(rollbackFor = Exception.class)
    public void open(String key) {
        systemConfigMapper.propertiesOpenOrClose(key, ProjectConstant.SUCCESS);
        getMap().put(key, ProjectConstant.SUCCESS);
    }

    public String getStringValue(String key) {
        return String.valueOf(get(key));
    }

    public Integer getIntegerValue(String key) {
        return Integer.parseInt(getStringValue(key));
    }

    public Long getLongValue(String key) {
        return Long.parseLong(getStringValue(key));
    }

    public boolean isBoolean(String key) {
        return get(key).equals(ProjectConstant.SUCCESS);
    }

    private Object get(String key) {
        Object value = getMap().get(key);
        if (StringUtils.isEmpty(value)) {
            value = systemConfigMapper.getSystemConfigValue(key);
            redissonClient.getMap(ProjectConstant.SYSTEM_CONFIG_MAP).put(key, value);
        }
        return value;
    }

    private RMap<String, String> getMap() {
        return redissonClient.getMap(ProjectConstant.SYSTEM_CONFIG_MAP);
    }

    /**
     * 刷新(重新加载一次数据到缓存)
     */
    public void refresh() {

        RMap<String, String> rMap = getMap();
        rMap.clear();

        SystemConfig systemConfig;
        List<SystemConfig> systemConfigList = systemConfigMapper.selectAll();
        for (SystemConfig config : systemConfigList) {
            systemConfig = config;
            rMap.put(systemConfig.getName(), systemConfig.getValue());
        }

        if (!systemConfigList.isEmpty()) {
            systemConfigList.clear();
        }
    }
}
