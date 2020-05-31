package group2.TASC.service;

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
    public User saveUser(User user) throws Exception{
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new Exception("Username already exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("USER");
        return userRepo.save(user);
    }

    @Override
    public User saveAdmin(User user) throws Exception {
        if(userRepo.findByUsername(user.getUsername()) != null) {
            throw new Exception("Admin already exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ADMIN");
        return userRepo.save(user);
    }

    @Override
    public User changeRole(String newRole, String username) {
        User user = userRepo.findByUsername(username);
        user.setRoles(newRole);
        return userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }
}
