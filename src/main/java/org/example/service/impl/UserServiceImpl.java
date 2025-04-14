package org.example.service.impl;

import org.example.dao.impl.UserDaoImpl;
import org.example.exceptions.*;
import org.example.model.User;
import org.example.service.UserService;

import java.util.Map;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    public void validatorUser(User user) {
        if (user.getName().length() < 3) throw new NameTooShortException("Слишком короткое имя");

        if (user.getAge() < 18) throw new UnderAgeException("Возраст младше 18 лет");

        if (!user.getEmail().contains("@gmail.com") && !user.getEmail().contains("@mail.ru")) throw new InvalidEmailException("Не правильный формат email");

        if (userDaoImpl.findUserByUsername(user.getUsername())) throw new DuplicateUserException("Пользователь с таким никнеймом уже существует");

        userDaoImpl.saveUser(user);
    }

    @Override
    public void findByUsername(String username) {
        if (username.length() < 3) throw new NameTooShortException("Слишком короткое имя");
        if (userDaoImpl.findUserByUsername(username)) {
            Map<String, Object> userInfo = userDaoImpl.getUserInfo(username);
            userInfo.forEach((Key, value) -> System.out.println(Key + value));
        } else {
            throw new UserNotFoundException("Данный пользователь не существует");
        }
    }

    @Override
    public void editUser(String username) {

    }

    @Override
    public void removeUser(String username) {

    }
}
