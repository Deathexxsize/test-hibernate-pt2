package org.example.controller.impl;

import org.example.controller.UserController;
import org.example.model.User;
import org.example.service.impl.UserServiceImpl;

import java.util.Scanner;

public class UserControllerImpl implements UserController {
    private final Scanner scanner = new Scanner(System.in);
    private final UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    public void handleCreateUser() {
        System.out.println("\n== Регистрация ==");

        System.out.println("\nВведите ваши данные: ");

        System.out.print("Имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите ваш возраст: ");
        int age = new Scanner(System.in).nextInt();
        System.out.print("Ваш email: ");
        String email = scanner.nextLine();
        System.out.print("Придумайте никнейм: ");
        String username = scanner.nextLine();

        User user = new User(name, age, email, username);

        userServiceImpl.validatorUser(user);
    }

    @Override
    public void handleFindUser() {
        System.out.println("\n== Поиск пользователя ==");

        System.out.print("\nВведите имя пользователя: ");
        String username = scanner.nextLine();

        userServiceImpl.findByUsername(username);
    }

    @Override
    public void handleUpdateUser() {

    }

    @Override
    public void handleDeleteUser() {

    }
}
