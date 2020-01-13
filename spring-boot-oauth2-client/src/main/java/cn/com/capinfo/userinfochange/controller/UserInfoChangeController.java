package cn.com.capinfo.userinfochange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin.liveconnect.SecurityContextHelper;

/**
 * @ClassName UserInfoChangeController
 * @Description TODO
 * @Author yuyu
 * @Date 2020/1/9 10:24
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/sso")
public class UserInfoChangeController {
    @GetMapping(value = "/indinfo")
    public ModelAndView toIndinfo(){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return new ModelAndView("index");
    }
    @GetMapping(value = "/urbmi")
    public ModelAndView toUrbmi(){
        return null;
    }

    @Autowired
    private OAuth2RestTemplate restTemplate;
    @GetMapping(value = "/test")
    public OAuth2AccessToken test(){
        OAuth2AccessToken accessToken = restTemplate.getAccessToken();
        return accessToken;
    }

}
