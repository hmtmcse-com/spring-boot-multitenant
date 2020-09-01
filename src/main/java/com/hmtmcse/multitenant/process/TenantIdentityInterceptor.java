package com.hmtmcse.multitenant.process;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;


@Component
public class TenantIdentityInterceptor implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest request) throws Exception {
        String tenant = request.getHeader("tenant");
        if (tenant == null){
            tenant = "vw";
        }
        System.out.println("-------- TenantIdentityInterceptor");
        ThreadTenantStorage.setTenantId(tenant);
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        ThreadTenantStorage.clear();
    }
}
