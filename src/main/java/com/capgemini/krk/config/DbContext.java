package com.capgemini.krk.config;

public class DbContext {

    private static DbContextEnum context = DbContextEnum.DB1;

    public static DbContextEnum getContext() {
        return context;
    }

    public static void setContext(DbContextEnum context) {
        DbContext.context = context;
    }
}
