
package cn.com.capinfo.userinfochange.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 *@ClassName QRAuthenticationEntryPoint
 *@Description 跳转北京通二维码登录
 *@Author yuyu
 *@Date 2020/1/9 14:51
 *@Version 1.0
 **/
public class QRAuthenticationEntryPoint implements AuthenticationEntryPoint,
		InitializingBean {

	private String loginUrl;

	/**
	 * Determines whether the Service URL should include the session id for the specific
	 * user. As of CAS 3.0.5, the session id will automatically be stripped. However,
	 * older versions of CAS (i.e. CAS 2), do not automatically strip the session
	 * identifier (this is a bug on the part of the older server implementations), so an
	 * option to disable the session encoding is provided for backwards compatibility.
	 *
	 * By default, encoding is enabled.
	 */
	private boolean encodeServiceUrlWithSessionId = true;

	// ~ Methods
	// ========================================================================================================

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.hasLength(this.loginUrl, "loginUrl must be specified");
	}

	@Override
	public final void commence(final HttpServletRequest servletRequest,
		   final HttpServletResponse response,
		   final AuthenticationException authenticationException)
			throws IOException
			 {
		final String redirectUrl = loginUrl;
		preCommence(servletRequest, response);
		response.sendRedirect(redirectUrl);
	}

	/**
	 * Template method for you to do your own pre-processing before the redirect occurs.
	 *
	 * @param request the HttpServletRequest
	 * @param response the HttpServletResponse
	 */
	protected void preCommence(final HttpServletRequest request,
			final HttpServletResponse response) {

	}

	public final String getLoginUrl() {
		return this.loginUrl;
	}


	public final void setLoginUrl(final String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public final void setEncodeServiceUrlWithSessionId(
			final boolean encodeServiceUrlWithSessionId) {
		this.encodeServiceUrlWithSessionId = encodeServiceUrlWithSessionId;
	}

	protected boolean getEncodeServiceUrlWithSessionId() {
		return this.encodeServiceUrlWithSessionId;
	}
}
