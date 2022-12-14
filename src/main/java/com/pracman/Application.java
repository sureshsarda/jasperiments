package com.pracman;


import javax.swing.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        StaticApiMock mock = new StaticApiMock("users");

        UserService service = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{UserService.class}, mock);

        List<UserService.User> allUsers = service.getAllUsers();
        System.out.println(allUsers);

    }

}
