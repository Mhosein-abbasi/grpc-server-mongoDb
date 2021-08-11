package com.example.server;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repository repository;

    public User create(String userName, String userFamily) {
        if (userName.isEmpty() || userFamily.isEmpty()) {
            System.out.println("empty field exception");
        }

        User user = new User(userName, userFamily);
        user.setUpdatedAt(new Date());
        user.setCreateAt(new Date());
        user.setDeleted(false);

        return repository.save(user);
    }
}
