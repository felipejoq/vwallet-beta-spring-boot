package com.uncodigo.vwallet.services.impl;

import com.uncodigo.vwallet.models.User;
import com.uncodigo.vwallet.repositories.IUserRepository;
import com.uncodigo.vwallet.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
