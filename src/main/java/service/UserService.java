package service;

import dao.IUserDao;
import dao.UserDao;
import domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserService {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("compagendaPU");
    private IUserDao dao;

    public List<User> getUsers() {
        EntityManager em = emf.createEntityManager();
        dao = new UserDao(em);
        return dao.getUsers();
    }

    public User getUser(long uid) {
        EntityManager em = emf.createEntityManager();
        dao = new UserDao(em);
        return dao.getUser(uid);
    }

    public String addUser(User user) {
        EntityManager em = emf.createEntityManager();
        dao = new UserDao(em);
        if(dao.addUser(user)) {
            return "Successfully created user";
        }
        else {
            return "User creation failed";
        }

    }

    public String editUser(User user) {
        EntityManager em = emf.createEntityManager();
        dao = new UserDao(em);
        if(dao.editUser(user)) {
            return "Successfully edited user " + user.getEmail();
        }
        else {
            return "Error while editing user";
        }
    }
}
