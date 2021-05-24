package net.cnki.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: tianjl
 * @Date: 2021/5/18 17:12
 * @Eamil: 2695062879@qq.com
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "net.cnki.app-demo")
public class ConfigBean {

    /**
     * 版本
     */
    private String version;
}
