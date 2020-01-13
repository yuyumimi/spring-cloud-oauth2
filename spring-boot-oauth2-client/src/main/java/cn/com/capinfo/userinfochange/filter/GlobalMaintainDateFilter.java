package cn.com.capinfo.userinfochange.filter;

import cn.com.capinfo.userinfochange.properties.RunDateDateProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 运维拦截filter
 * 1至4号维护不提供服务
 */
@Component(value = "globalMaintainDateFilter")
public class GlobalMaintainDateFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private ServerProperties serverProperties;
    @Autowired
    private RunDateDateProperties dateProperties;
    private AntPathMatcher matcher = new AntPathMatcher();

    @Value("${sior.wssb.maintainDate.enable:true}")
    private boolean enableMaintain;

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException,
            ServletException {
        if (this.dateProperties.isEnable()) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String requestURI = request.getRequestURI();
            if (excludeRouces(requestURI,this.dateProperties.getIgnoreUri())) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            if (isMaintainDate()) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 检查是运维期吗
     *
     * @return
     */
    private boolean isMaintainDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        int dayOfMonth = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();
        if (isMaintainDay(dayOfMonth) || isMaintainHour(hour)) {
            return true;
        }
        return false;
    }

    private boolean isMaintainDay(int dayOfMonth) {
        if (dayOfMonth >= this.dateProperties.getStartDay()
                && dayOfMonth <= this.dateProperties.getEndDay()) {
            return false;
        }
        return true;
    }

    private boolean isMaintainHour(int hour) {
        if (hour >= this.dateProperties.getStartHour()
                && hour <= this.dateProperties.getEndHour()) {
            return false;
        }
        return true;
    }

    /**
     * 不拦截资源判断
     *
     * @param uri
     * @param patterns
     * @return
     */
    private boolean excludeRouces(String uri, String... patterns) {
        int size = patterns.length;
        for (int i = 0; i < size; i++) {
            if (matcher.match(patterns[i], uri)) {
                return true;
            }
        }
        return false;
    }
}
