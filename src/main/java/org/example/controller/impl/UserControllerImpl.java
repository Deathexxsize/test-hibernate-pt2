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

        // User user = new User(name, age, email, username);

        // userServiceImpl.addUser(user);
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
        System.out.println("\n\n== Редактировать пользователя ==");

        System.out.print("\nНайдите пользователя чтобы редактировать: ");
        String oldUsername = scanner.nextLine();

            System.out.print("\n\n== Введите новые данные ==");

            System.out.print("\nИмя: ");
            String newName = scanner.nextLine();
            System.out.print("Введите возраст: ");
            int newAge = new Scanner(System.in).nextInt();
            System.out.print("Ваш email: ");
            String newEmail = scanner.nextLine();
            System.out.print("Придумайте никнейм: ");
            String newUsername = scanner.nextLine();

            // User newUserData = new User(newName, newAge, newEmail, newUsername);

            // userServiceImpl.editUser(oldUsername, newUserData);
    }

    @Override
    public void handleDeleteUser() {
        System.out.println("\n\n== Удаление пользователя ==");

        System.out.print("Введите ник игррока для удаление: ");
        String deleteUser = scanner.nextLine();

        userServiceImpl.removeUser(deleteUser);
    }
}
