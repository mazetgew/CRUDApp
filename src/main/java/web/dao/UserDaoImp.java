package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(User user) {

        em.persist(user);

    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void remove(User user) {
        em.remove(user);
    }

    @Override
    public List<User> listUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}