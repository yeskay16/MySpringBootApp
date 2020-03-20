package com.ibm.restapi.service;

import com.ibm.restapi.exception.NotFoundException;
import com.ibm.restapi.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    public static List<User> users = new ArrayList<>();
    static {

        users.add(new User(1000, "Pankaj"));
        users.add(new User(1001, "Rohit"));
        users.add(new User(1002, "Anuj"));
    }
    public User getUserFromListOrDb(int id) {

            for (User user : users) {
                if (id == user.getId()) {
                    return user;
                }
            }


        return null;
    }

    public User createUser(User user) {
        if (null != user) {
            users.add(user);
            return user;
        }
    return  null;
    }

}
