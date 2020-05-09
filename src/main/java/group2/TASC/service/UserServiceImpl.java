package group2.TASC.service;

import group2.TASC.model.User;
import group2.TASC.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAllByOrderByStudentIdAsc();
    }

    @Override
    public User getUserById(long studentId) {
        return userRepo.findByStudentId(studentId);
    }

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }
}
