package com.crudApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crudApp.Users;
@Repository
public interface UserRepository extends MongoRepository<Users, String> {
			public Users findByName(String name);
}
