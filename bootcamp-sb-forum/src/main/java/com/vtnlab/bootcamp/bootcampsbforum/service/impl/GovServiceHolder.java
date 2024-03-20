package com.vtnlab.bootcamp.bootcampsbforum.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtnlab.bootcamp.bootcampsbforum.mapper.GovMapper;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtnlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;
import com.vtnlab.bootcamp.bootcampsbforum.service.GovService;
import com.vtnlab.bootcamp.bootcampsbforum.service.UserService;
@Service
public class GovServiceHolder implements GovService{

    @Autowired
    private UserService userService;

    @Autowired
    private ForumDatabaseService forumDatabaseService;

    @Autowired
    private GovMapper govMapper;

    @Override
    public User getUser(int id) {
        User user = userService.getUser(id);
        if (user!=null) {
            forumDatabaseService.saveUser(govMapper.mapEntity(user));
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userService.getUsers();
        forumDatabaseService.deleteAllUsers();
        List<com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity> userEntities=users.stream()
                    .map(e->govMapper.mapEntity(e))
                    .collect(Collectors.toList());
        forumDatabaseService.saveUsers(userEntities);
        return users;
    }

   
    
}
