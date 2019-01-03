package com.yh.springcloudauth2resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;


/**
 * 启用全局方法安全性并配置MethodSecurityExpressionHandler
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2ResourceServerConfig
        extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }

    /**
     * 此RemoteTokenService将使用授权服务器上的CheckTokenEndPoint来验证AccessToken并从中获取Authentication对象。
     * 可以在AuthorizationServerBaseURL +“ / oauth / check_token ”找到
     * Authorization Server可以使用任何TokenStore类型[ JdbcTokenStore，JwtTokenStore，...] - 这不会影响RemoteTokenService或Resource服务器。
     * @return
     */

    @Primary
    @Bean
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(
                "http://localhost:9091/oauth/check_token");
        tokenService.setClientId("clientapp");
        tokenService.setClientSecret("123");
        return tokenService;
    }
}