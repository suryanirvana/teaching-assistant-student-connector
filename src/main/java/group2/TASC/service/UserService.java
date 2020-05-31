package group2.TASC.service;

import group2.TASC.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user) throws Exception;

    User saveAdmin(User user) throws Exception;

    User changeRole(String newRole, String username);

    User findByUsername(String username);

    List<User> findAllUsers();
}
