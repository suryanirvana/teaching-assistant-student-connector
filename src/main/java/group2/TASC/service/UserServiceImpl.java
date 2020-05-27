package group2.TASC.service;

import group2.TASC.model.User;
import group2.TASC.model.UserDTO;
import group2.TASC.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public boolean registerNewUserAccount(UserDTO userDTO) {
        System.out.println(userRepo.findByUserId(userDTO.getUserId()));
        if((userRepo.findByUserId(userDTO.getUserId()) == null)) {

            Student student = new Student(userDTO.getUserId(),
                    userDTO.getStudentId(), userDTO.getName(), userDTO.getUsername(), userDTO.getPassword(),
                    userDTO.getEmail(), userDTO.getRole());
            student.setStudentId(userDTO.getStudentId());
            student.setUsername(userDTO.getUsername());
            student.setPassword(userDTO.getPassword());
            student.setName(userDTO.getName());
            student.setEmail(userDTO.getEmail());
            userRepo.save(student);
            return true;

        }
        System.out.println("Same Id, Rejected");
        return false;
    }

    @Override
    public boolean authenticate(String username, String password) {
        if (userRepo.findByUsername(username) != null) {
            User user = userRepo.findByUsername(username);
            return user.getPassword().equals(password);
        }
        return false;
    }
}
