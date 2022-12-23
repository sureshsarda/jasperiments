package com.pracman;

import com.google.gson.Gson;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class StaticApiMock implements InvocationHandler {

    final Gson GSON = new Gson();

    /**
     * This is used only for grouping the responses across a larger project
     */
    private final String baseDirectory;

    private StaticApiMock(String baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    public static <T> T createMock(String baseDirectory, Class<T> tClass) {
        StaticApiMock mock = new StaticApiMock(baseDirectory);

        return tClass.cast(Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{tClass}, mock));
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // read from the directory
        InputStream resourceAsStream = proxy.getClass().getClassLoader().getResourceAsStream(baseDirectory + File.separator + method.getName() +
                ".json");
        assert resourceAsStream != null;
        String contents = new String(resourceAsStream.readAllBytes());

        // convert to object, use the return type of the method to parse the string
        return GSON.fromJson(contents, method.getGenericReturnType());
    }
}
