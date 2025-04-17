package org.example.service;

import org.example.model.User;

public interface UserService {
    public void validatorUser(User user, boolean isUpdate);
    public void findByUsername(String username);
    public void editUser (String username, User userNewData);
    public void removeUser(String username);
}
