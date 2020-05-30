package group2.TASC.service;

import group2.TASC.model.Role;
import group2.TASC.model.User;
import group2.TASC.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        return userRepo.save(user);
    }

    @Override
    public User changeRole(Role newRole, String username) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new RuntimeException());
        user.setRole(newRole);
        return userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }
}
