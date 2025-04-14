package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.infrastructure.HibernateUtil;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser(User user) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.save(user);
            tx.commit();
            System.out.println("\nПользователь успешно сохранен");
        } catch (Exception e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
            System.out.println("Ошибка при сохранении пользователя");
        }
    }

    @Override
    public Map<String, Object> getUserInfo(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM User WHERE username = :username";
            User user = session.createQuery(hql, User.class)
                    .setParameter("username", username)
                    .uniqueResult();

            Map<String, Object> userInfo = new HashMap<>();

            userInfo.put("Имя пользователя: ", user.getName());
            userInfo.put("Возраст: ", user.getAge());
            userInfo.put("Никнейм: ", user.getUsername());

            return userInfo;
        }
    }

    @Override
    public void updateUser(User user) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            tx = session.beginTransaction();

            session.update(user);
            tx.commit();
            System.out.println("Данные пользователя успешно обновлены");
        } catch (Exception e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
            System.out.println("Ошибка при обновление данных пользователя");
        }
    }

    @Override
    public void deleteUser(User user) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.delete(user);
            tx.commit();
            System.out.print("Пользователь успешно удален");
        } catch (Exception e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
            System.out.println("Ошибка при удалении пользователя");
        }
    }

    public boolean findUserByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long count = session.createQuery(
                    "SELECT COUNT(u) FROM User u WHERE u.username = :username", Long.class)
                    .setParameter("username", username)
                    .uniqueResult();

            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
