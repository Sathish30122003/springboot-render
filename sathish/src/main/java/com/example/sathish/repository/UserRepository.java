package com.example.sathish.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.sathish.modules.User;

@Component
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
   

}
