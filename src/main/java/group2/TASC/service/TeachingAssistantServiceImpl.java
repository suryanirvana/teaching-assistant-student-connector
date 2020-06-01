package group2.TASC.service;

import group2.TASC.model.Student;
import group2.TASC.model.TeachingAssistant;
import group2.TASC.model.User;
import group2.TASC.repository.TeachingAssistantRepo;
import group2.TASC.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachingAssistantServiceImpl implements TeachingAssistantService {

    @Autowired
    TeachingAssistantRepo teachingAssistantRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @Override
    public TeachingAssistant addTA(String username) {
        User user = userService.findByUsername(username);
        user.setRoles(user.getRoles() + ",TA");
        userRepo.save(user);

        TeachingAssistant teachingAssistant = new TeachingAssistant();
        teachingAssistant.setStudent_id(user.getStudent_id());
        teachingAssistant.setUsername(username);
        return teachingAssistantRepo.save(teachingAssistant);
    }
}
