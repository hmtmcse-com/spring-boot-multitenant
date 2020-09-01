package com.hmtmcse.multitenant.process;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {

    private final TenantIdentityInterceptor tenantIdentityInterceptor;

    public InterceptorConfigurer(TenantIdentityInterceptor tenantIdentityInterceptor) {
        this.tenantIdentityInterceptor = tenantIdentityInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(tenantIdentityInterceptor);
    }
}
