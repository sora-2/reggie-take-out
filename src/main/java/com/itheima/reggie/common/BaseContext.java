package com.itheima.reggie.common;

public class BaseContext {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<Long>();

    public static void setCurrentId(long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
