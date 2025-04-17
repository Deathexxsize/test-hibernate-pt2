package org.example.service.impl;

import org.example.dao.impl.UserDaoImpl;
import org.example.exceptions.*;
import org.example.model.User;
import org.example.service.UserService;

import java.util.Map;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    public void addUser(User user) {
        if (validatorUser(user)) {
            userDaoImpl.saveUser(user);
        }
    }

    @Override
    public boolean validatorUser(User user) { // проверяет исходоящие данные пользователя

        if (user.getName().length() < 3) {
            throw new NameTooShortException("Слишком короткое имя");
        }

        if (user.getAge() < 18) {
            throw new UnderAgeException("Возраст младше 18 лет");
        }

        if (!user.getEmail().contains("@gmail.com") && !user.getEmail().contains("@mail.ru")) {
            throw new InvalidEmailException("Неправильный формат email");
        }

        if (userDaoImpl.findUserByUsername(user.getUsername())) {
            throw new DuplicateUserException("Пользователь с таким никнеймом уже существует");
        }

        return true;
    }

    @Override
    public void findByUsername(String username) { // Ищет пользователя и выводит на экран
        if (username.length() < 3) throw new NameTooShortException("Слишком короткое имя");
        if (userDaoImpl.findUserByUsername(username)) {
            Map<String, Object> userInfo = userDaoImpl.getUserInfo(username);
            userInfo.forEach((Key, value) -> System.out.println(Key + value));
        } else {
            throw new UserNotFoundException("Данный пользователь не существует");
        }
    }

    @Override
    public void editUser(String oldUsername, User newUserData) {
        User existingUser = userDaoImpl.getUserByUsername(oldUsername);

        if (existingUser == null) throw new UserNotFoundException("Пользователь не найден");

        if (!oldUsername.equals(newUserData.getUsername()) &&
                userDaoImpl.findUserByUsername(newUserData.getUsername())) {
            throw new DuplicateUserException("Новый никнейм уже занят");
        }

        if (validatorUser(newUserData)) {
            existingUser.setName(newUserData.getName());
            existingUser.setAge(newUserData.getAge());
            existingUser.setEmail(newUserData.getEmail());
            existingUser.setUsername(newUserData.getUsername());

            userDaoImpl.updateUser(existingUser);
        }
    }

    @Override
    public void removeUser(String username) { //
        if (username.length() < 3) throw  new UserNotFoundException("Слишком короткое имя");

        if (userDaoImpl.findUserByUsername(username)) {
            userDaoImpl.deleteUser(username);
        } else {
            throw new UserNotFoundException("Данный пользователь не существует");
        }
    }
}
