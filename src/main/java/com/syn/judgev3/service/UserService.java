package com.syn.judgev3.service;


import com.syn.judgev3.model.service.UserServiceModel;

public interface UserService {

    UserServiceModel getUserByUsername(String username);

    UserServiceModel createUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserServiceModel getById(String userId);
}
