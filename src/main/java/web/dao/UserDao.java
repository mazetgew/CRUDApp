package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void update(User user);

    void remove(User user);

    List<User> listUsers();

}