package cn.com.capinfo.userinfochange.config;

import cn.com.capinfo.userinfochange.security.QRAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @ClassName Oauth2ClientConfiguration
 * @Description TODO
 * @Author yuyu
 * @Date 2020/1/12 14:39
 * @Version 1.0
 **/
@Configuration
@EnableOAuth2Client
public class Oauth2ClientConfiguration {
    @Autowired
    private OAuth2ClientContext oauth2ClientContext;
    @Autowired
    private AuthorizationCodeResourceDetails authorizationCodeResourceDetails;

    @Bean
    public OAuth2RestTemplate restTemplate() {
        return new OAuth2RestTemplate(authorizationCodeResourceDetails,
                oauth2ClientContext);
    }

}
