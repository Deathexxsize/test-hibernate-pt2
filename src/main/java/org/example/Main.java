package org.example;

import org.example.controller.impl.UserControllerImpl;
import org.example.infrastructure.HibernateUtil;
import org.example.model.University;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main {
    private static final UserControllerImpl userControllerImpl = new UserControllerImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n1. Создать пользователя\n2. Найти пользователя\n3. Обновить данные пользователя\n4. Удалить пользователя");
        System.out.print("Выбрать: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                userControllerImpl.handleCreateUser();
                break;
            case 2:
                userControllerImpl.handleFindUser();
                break;
            case 3:
                userControllerImpl.handleUpdateUser();
                break;
            case 4:
                userControllerImpl.handleDeleteUser();
                break;
            default:
                System.out.println("Не вернон значение");
                break;
        }

    }
}