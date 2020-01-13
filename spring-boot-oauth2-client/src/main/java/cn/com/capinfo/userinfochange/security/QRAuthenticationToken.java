package cn.com.capinfo.userinfochange.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class QRAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = 1L;

	/**
	 * 授权类型grant_type
	 */
	private final Object principal;
	/**
	 * 授权code grant_code
	 */
	private final Object credentials;

	public QRAuthenticationToken(Object aPrincipal, Object aCredentials) {
		super(null);
		this.principal = aPrincipal;
		this.credentials = aCredentials;
	}

	public QRAuthenticationToken(Object aPrincipal, Object aCredentials,
			Collection<? extends GrantedAuthority> anAuthorities) {
		super(anAuthorities);
		this.principal = aPrincipal;
		this.credentials = aCredentials;
		setAuthenticated(true);
	}

	/**
	 * Get the credentials
	 */
	@Override
	public Object getCredentials() {
		return this.credentials;
	}

	/**
	 * Get the principal
	 */
	@Override
	public Object getPrincipal() {
		return this.principal;
	}

}
