package group2.TASC.service;

import group2.TASC.model.Course;
import group2.TASC.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(long id);

}
