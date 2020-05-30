package group2.TASC.service;

import group2.TASC.model.Role;
import group2.TASC.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User changeRole(Role newRole, String username);

    User findByUsername(String username);

    List<User> findAllUsers();
}
