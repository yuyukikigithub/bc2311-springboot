package com.vtnlab.bootcamp.bootcampsbforum.service;

import java.util.List;

import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface GovService {
    /**
     * 1. Invoke JPH API to retrieve User List
     * 2. store/refresh the whole user list in database
     * 3. return to Gov
     * @param id
     * @return
     */

    //  List<User> savUsers (List<User> users);
    User getUser(int id);

    List<User> getUsers();
    
} 