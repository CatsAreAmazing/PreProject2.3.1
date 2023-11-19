package com.example.preproject231.dao;


import com.example.preproject231.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    //почему-то без сортировки по id они могли идти вразнобой если удалить что-то... Так и не понял из-за чего
    public List<User> index() {
        return em.createQuery("from User order by id", User.class).getResultList();
    }

    @Override
    public User read(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated = read(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setTp(updatedUser.getTp());
    }

    @Override
    public void delete(int id) {
        em.remove(read(id));
    }
}
