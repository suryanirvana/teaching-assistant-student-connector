package group2.TASC.service;

import group2.TASC.model.UserDTO;

public interface UserService {
    boolean registerNewUserAccount(UserDTO userDTO);
    boolean authenticate (String username, String password);
}
