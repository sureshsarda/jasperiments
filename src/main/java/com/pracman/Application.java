package com.pracman;


import javax.swing.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // users is a directory under which grouping is happening
        StaticApiMock mock = new StaticApiMock("users");

        // create a mock service
        UserService service = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{UserService.class}, mock);


        // use the mocked service
        List<UserService.User> allUsers = service.getAllUsers();
        System.out.println(allUsers);

    }

}
