package com.designpatterns;

public class DbSingleton {

    private static DbSingleton dbSingleton = null;

    private DbSingleton(){
    }

    public static synchronized DbSingleton getDbSingleton(){
        if (dbSingleton == null){
            dbSingleton = new DbSingleton();
        }
        return dbSingleton;
    }
}
