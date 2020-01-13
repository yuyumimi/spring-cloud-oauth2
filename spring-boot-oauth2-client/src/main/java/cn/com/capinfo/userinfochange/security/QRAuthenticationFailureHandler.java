package cn.com.capinfo.userinfochange.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CasAuthenticationFailureHandler
 * @Description TODO
 * @Author yuyu
 * @Date 2019/7/22 9:54
 * @Version 1.0
 **/
@Component
@Slf4j
public class QRAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        log.info("公共服务平台cas登录失败");
        super.onAuthenticationFailure(request, response, exception);
    }
}
