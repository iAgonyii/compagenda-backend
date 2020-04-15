package dao;

import domain.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface IUserDao {
    List<User> getUsers();
    User getUser(long uid);
    boolean register(User u);
    boolean editUser(User user);
    long getIdForName(String username);
    String getPassword(Long id);
    boolean CheckIfAlreadyExists(User user);
}
