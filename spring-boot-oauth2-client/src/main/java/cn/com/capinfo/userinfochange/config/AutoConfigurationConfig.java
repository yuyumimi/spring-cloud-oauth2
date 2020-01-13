package cn.com.capinfo.userinfochange.config;

import cn.com.capinfo.userinfochange.properties.RunDateDateProperties;
import cn.com.capinfo.userinfochange.properties.SiorWssbQRSecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AutoConfigurationConfig
 * @Description TODO
 * @Author yuyu
 * @Date 2019/12/19 12:24
 * @Version 1.0
 **/
@Configuration
@EnableConfigurationProperties({RunDateDateProperties.class,
        SiorWssbQRSecurityProperties.class})
public class AutoConfigurationConfig {
}
