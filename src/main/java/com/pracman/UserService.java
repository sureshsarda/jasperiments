package com.pracman;

import java.util.List;

public interface UserService {

    class User {
        String firstName;
        String lastName;
    }

    List<User> getAllUsers();

    List<User> filterUsers(User filter);

}
