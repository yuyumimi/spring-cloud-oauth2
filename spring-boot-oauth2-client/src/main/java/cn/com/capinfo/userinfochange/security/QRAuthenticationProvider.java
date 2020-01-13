package cn.com.capinfo.userinfochange.security;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName QRAuthenticationProvider
 * @Description TODO
 * @Author yuyu
 * @Date 2020/1/9 13:15
 * @Version 1.0
 **/
public class QRAuthenticationProvider implements AuthenticationProvider,
        InitializingBean, MessageSourceAware {
    private AuthenticationUserDetailsService<QRAuthenticationToken> authenticationUserDetailsService;
    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        this.restTemplate.get

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (QRAuthenticationToken.class
                .isAssignableFrom(authentication));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.authenticationUserDetailsService,
                "An authenticationUserDetailsService must be set");
        Assert.notNull(this.messages, "A message source must be set");
    }

    @Override
    public void setMessageSource(final MessageSource messageSource) {
        this.messages = new MessageSourceAccessor(messageSource);
    }
}
