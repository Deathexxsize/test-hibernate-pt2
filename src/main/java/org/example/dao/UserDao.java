package org.example.dao;

import org.example.model.User;

public interface UserDao {
    public void saveUser(User user);
    public User getUserById(int id);
    public void updateUser(User user);
    public void deleteUser(User user);
}
