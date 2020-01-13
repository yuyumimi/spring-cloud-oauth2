package cn.com.capinfo.userinfochange.config;

import cn.com.capinfo.userinfochange.properties.SiorWssbQRSecurityProperties;
import cn.com.capinfo.userinfochange.security.QRAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @ClassName WebSecurityConfigurer
 * @Description TODO
 * @Author yuyu
 * @Date 2019/7/8 15:52
 * @Version 1.0
 **/
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private SiorWssbQRSecurityProperties qrSecurityProperties;
    /**
     * 定义认证用户信息获取来源，密码校验规则等
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authenticationProvider()
        http.exceptionHandling().authenticationEntryPoint(qrAuthenticationEntryPoint());
        http.formLogin().disable().httpBasic().disable();
//                .authorizeRequests()
//                .antMatchers(
//                        "/error",
//                        "/fail/**",
//                        "/maintain/**")
//                .permitAll()
//                .anyRequest()
////                .permitAll()
//                .authenticated()
//                .and()
//                .logout().and();
    }
    public AuthenticationEntryPoint qrAuthenticationEntryPoint() {
        QRAuthenticationEntryPoint qrAuthenticationEntryPoint =
                new QRAuthenticationEntryPoint();
        qrAuthenticationEntryPoint.setLoginUrl(qrSecurityProperties.getLoginUrl());
        return qrAuthenticationEntryPoint;
    }
}
