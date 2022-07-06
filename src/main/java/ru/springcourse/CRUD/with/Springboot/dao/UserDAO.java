package ru.springcourse.CRUD.with.Springboot.dao;



import ru.springcourse.CRUD.with.Springboot.models.User;

import java.util.List;

public interface UserDAO {

    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);


}