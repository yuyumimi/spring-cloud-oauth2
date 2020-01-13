package cn.com.capinfo.userinfochange.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "sior.wssb.qr-security")
public class SiorWssbQRSecurityProperties {

    private String loginUrl;
    private String tokenUrl;
    private String UserInfoUrl;
}
