package com.example.sathish.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sathish.modules.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    // Custom query methods can be added here
}
