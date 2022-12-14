package com.pracman;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class StaticApiMock implements InvocationHandler {


    private String baseDirectory;

    public StaticApiMock(String baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getDeclaringClass());
        System.out.println(method.getName());

        InputStream resourceAsStream = proxy.getClass().getResourceAsStream(baseDirectory + "\\" + method.getName() +
                ".json");
        assert resourceAsStream != null;
        System.out.println(new String(resourceAsStream.readAllBytes()));


        System.out.println(proxy.getClass());

        System.out.println(method);
        System.out.println(Arrays.toString(args));
        return null;
    }
}
