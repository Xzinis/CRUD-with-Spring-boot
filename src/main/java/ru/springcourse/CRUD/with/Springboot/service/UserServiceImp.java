package ru.springcourse.CRUD.with.Springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springcourse.CRUD.with.Springboot.dao.UserDAO;
import ru.springcourse.CRUD.with.Springboot.models.User;


import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Transactional
    @Override
    public User show(int id) {
        return userDAO.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    @Override
    public void update(int id, User updatedUser) {
        userDAO.update(id, updatedUser);

    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
