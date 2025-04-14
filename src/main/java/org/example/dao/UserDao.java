package org.example.dao;

import org.example.model.User;

import java.util.Map;
import java.util.Objects;

public interface UserDao {
    public void saveUser(User user);
    public Map<String, Object> getUserInfo(String username);
    public void updateUser(User user);
    public void deleteUser(User user);
}
