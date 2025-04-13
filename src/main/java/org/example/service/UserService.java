package org.example.service;

import org.example.model.User;

public interface UserService {
    public void validatorUser(User user);
    public void findById (int id);
    public void editUser (String username);
    public void removeUser(String username);
}
