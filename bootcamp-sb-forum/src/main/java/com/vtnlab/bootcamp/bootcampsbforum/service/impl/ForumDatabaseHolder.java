package com.vtnlab.bootcamp.bootcampsbforum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtnlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtnlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;
@Service
public class ForumDatabaseHolder implements ForumDatabaseService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<UserEntity> saveUsers(List<UserEntity> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
    
}
