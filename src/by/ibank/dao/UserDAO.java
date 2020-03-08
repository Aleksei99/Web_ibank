package by.ibank.dao;

import by.ibank.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();

    User find(int id);

    boolean save(User user);

    void delete(int id);

    void update(User user);
}
