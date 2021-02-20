package com.syn.judgev3.service.impl;

import com.syn.judgev3.model.entity.User;
import com.syn.judgev3.model.service.UserServiceModel;
import com.syn.judgev3.repository.UserRepository;
import com.syn.judgev3.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel getUserByUsername(String username) {
        return this.modelMapper.map(
                this.userRepository.findByUsername(username),
                UserServiceModel.class);
    }

    @Override
    public UserServiceModel createUser(UserServiceModel userServiceModel) {
        userServiceModel.setPassword(DigestUtils.sha256Hex(userServiceModel.getPassword()));
        try {
            return this.modelMapper.map(
                    this.userRepository.save(this.modelMapper.map(userServiceModel, User.class)),
                    UserServiceModel.class);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        String encodedPassword = DigestUtils.sha256Hex(password);
        return this.userRepository.findByUsernameAndPassword(username, encodedPassword)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public UserServiceModel getById(String userId) {
        return this.userRepository.findById(userId)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
