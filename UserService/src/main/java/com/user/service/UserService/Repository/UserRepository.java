package com.user.service.UserService.Repository;

import com.user.service.UserService.Entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

//    public User findById(String id){
//        return new User();
//    }
//
//    public User save(User user){
//        return new User();
//    }
//
//    public List<User> findAll(){
//        return new ArrayList<>();
//    }
}