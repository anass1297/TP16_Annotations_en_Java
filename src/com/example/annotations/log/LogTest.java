package com.example.annotations.log;

import java.lang.reflect.Method;

public class LogTest {

    @Loggable
    public int addition(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        LogTest obj = new LogTest();
        Method m = LogTest.class.getMethod("addition", int.class, int.class);
        LogProcessor.invoke(obj, m, 4, 6);
    }
}
