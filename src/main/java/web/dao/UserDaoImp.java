package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void add(User user) {
        try {
            em.persist(user);
            System.out.println("Пользователь добавлен");
        } catch (Exception e) {
            System.out.println("Не удалось добавить пользователя" + e);
        }
    }

    @Override
    @Transactional
    public void update(User user) {
        try {
            em.merge(user);
            System.out.println("Данные пользователя обновлены");
        } catch (Exception e) {
            System.out.println("Не удалось обновить данные пользователя" + e);
        }
    }

    @Override
    @Transactional
    public void remove(User user) {
        try {
            em.remove(user);
            System.out.println("Пользователь удалён");
        } catch (Exception e) {
            System.out.println("Не удалось удалить пользователя");
        }
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        try {
            System.out.println("Список пользователей получен");
            return em.createQuery("select u from User u", User.class).getResultList();
        } catch (Exception e) {
            System.out.println("Не удалось получить список пользователей");
            return null;
        }
    }
}