package dao;

import domain.User;

public interface IAuthDao {
    boolean register(User u);
    String getPassword(Long id);
    boolean CheckIfAlreadyExists(User user);
}
