package com.pracman;

import java.util.List;

public interface UserService {

    class User {
        String firstName;
        String lastName;

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    List<User> getAllUsers();

}
