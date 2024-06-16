package com.uncodigo.vwallet.services;

import com.uncodigo.vwallet.models.User;

import java.util.List;

public interface IUserService {
    User getUserById(int id);
    List<User> getAllUsers();
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(int id);
}
