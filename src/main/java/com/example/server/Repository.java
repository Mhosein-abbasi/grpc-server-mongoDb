package com.example.server;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends MongoRepository<User, String> {
    Optional<User> findById(String id);

}
