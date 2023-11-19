package com.example.preproject231.service;

import com.example.preproject231.dao.UserDao;
import com.example.preproject231.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Transactional(readOnly = true)
    @Override
    public User read(int id) {
        return userDao.read(id);
    }

    @Transactional
    @Override
    public void update(int id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
