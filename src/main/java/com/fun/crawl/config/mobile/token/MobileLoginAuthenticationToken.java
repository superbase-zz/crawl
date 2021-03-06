package com.fun.crawl.config.mobile.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * 手机登录token
 *
 * @author ： CatalpaFlat
 * @date ：Create in 21:48 2017/12/20
 */
public class MobileLoginAuthenticationToken extends AbstractAuthenticationToken {
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
    private static final Logger logger = LoggerFactory.getLogger(MobileLoginAuthenticationToken.class.getName());

    private final Object principal;

    private Object credentials;

    public MobileLoginAuthenticationToken(String mobile,String inputCode) {
        super(null);
        this.principal = mobile;
        this.credentials = inputCode;
        setAuthenticated(false);
        logger.info("MobileLoginAuthenticationToken setAuthenticated ->false loading ...");
    }

    public MobileLoginAuthenticationToken(Object principal,Object credentials,
                                          Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        // must use super, as we override
        //验证的值
        this.credentials = credentials;
        super.setAuthenticated(true);
        logger.info("MobileLoginAuthenticationToken setAuthenticated ->true loading ...");
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        if (authenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}
