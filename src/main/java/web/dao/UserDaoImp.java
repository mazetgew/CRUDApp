package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    public final EntityManagerFactory emf;

    public UserDaoImp(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void add(User user) {
        try {
            emf.createEntityManager().persist(user);
        } catch (Exception e) {
            System.out.println("Не удалось добавить пользователя" + e);
        }
    }

    @Override
    public void update(User user) {
    }

    @Override
    public void remove(User user) {
    }

    @Override
    public List<User> listUsers() {
        return null;
    }
}
