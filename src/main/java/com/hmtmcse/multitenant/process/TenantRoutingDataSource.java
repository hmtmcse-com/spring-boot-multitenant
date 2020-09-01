package com.hmtmcse.multitenant.process;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class TenantRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        Object data = ThreadTenantStorage.getTenantId();
        if (data == null){
            data = "vw";
        }
        System.out.println(data);
        return data;
    }

}