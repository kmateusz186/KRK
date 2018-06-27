package com.capgemini.krk.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiDbDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DbContext.getContext();
    }

}