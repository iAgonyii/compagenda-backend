package dao;

import domain.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface IUserDao {
    List<User> getUsers();
    User getUser(long uid);
    boolean addUser(User u);
    boolean editUser(User user);
}
