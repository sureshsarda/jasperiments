package com.pracman;


import javax.swing.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        UserService service = StaticApiMock.createMock("users", UserService.class);

        // use the mocked service
        List<UserService.User> allUsers = service.getAllUsers();
        System.out.println(allUsers);

    }

}
