package cn.com.capinfo.userinfochange.config;

import cn.com.capinfo.userinfochange.filter.GlobalMaintainDateFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WebServerCustomConfig
 * @Description TODO
 * @Author yuyu
 * @Date 2019/8/14 9:16
 * @Version 1.0
 **/
@Configuration
public class WebServerCustomConfig {

    @Autowired
    private GlobalMaintainDateFilter globalFilter;

    @Bean
    public FilterRegistrationBean filterRegistration() {
        // 新建过滤器注册类
//   DelegatingFilterProxyRegistrationBean     FilterRegistrationBean
        FilterRegistrationBean registration =
                new FilterRegistrationBean();
        // 添加自定义 过滤器
        registration.setFilter(globalFilter);
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        //设置过滤器顺序
        registration.setOrder(-1000);
        return registration;
    }

    /**
     * 设置服务器对404错误的处理，适应vue展示
     *
     * @return
     */
//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
//        WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer = factory -> {
//            ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND,
//                    "/index");
//            factory.addErrorPages(errorPage404);
//            ErrorPage errorPage403 = new ErrorPage(HttpStatus.FORBIDDEN,
//                    "/index");
//            factory.addErrorPages(errorPage404);
//            factory.addErrorPages(errorPage403);
//
//        };
//        return webServerFactoryCustomizer;
//    }
}
