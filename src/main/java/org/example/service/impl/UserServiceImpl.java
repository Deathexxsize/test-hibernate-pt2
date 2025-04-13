package org.example.service.impl;

import org.example.dao.impl.UserDaoImpl;
import org.example.exceptions.DuplicateUserException;
import org.example.exceptions.InvalidEmailException;
import org.example.exceptions.NameTooShortException;
import org.example.exceptions.UnderAgeException;
import org.example.model.User;
import org.example.service.UserService;

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
    public void findById(int id) {

    }

    @Override
    public void editUser(String username) {

    }

    @Override
    public void removeUser(String username) {

    }
}
