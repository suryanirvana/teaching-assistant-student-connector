package group2.TASC.controller;

import group2.TASC.model.Course;
import group2.TASC.model.User;
import group2.TASC.repository.CourseRepo;
import group2.TASC.service.CourseService;
import group2.TASC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    private static final String REDIRECT_SEE_COURSE = "redirect:/seecourse";
    private static final String COURSE = "COURSE";
    private static final String TA = "TA";
    private static final String COURSE_EDIT = "course";

    @GetMapping("/seecourse")
    public String coursePage(Model model) {
        List<User> TAList = new ArrayList<>();
        for(User user : userService.findAllUsers()) {
            if (user.getRoleList().contains("TA")) {
                TAList.add(user);
            }
        }
        model.addAttribute(COURSE, courseService.getAllCourse());
        model.addAttribute("ta", new ArrayList<>());
        model.addAttribute(TA, TAList);
        return "see-course";
    }

    @GetMapping("/add/course")
    public String showAddCourseForm() {
        return "add-course";
    }

    @PostMapping("/addcourse")
    public String addCourse(@Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-course";
        }
        courseService.addCourse(course);
        model.addAttribute(COURSE, courseService.getAllCourse());
        return REDIRECT_SEE_COURSE;
    }

    @GetMapping("/edit/{courseCode}")
    public String showUpdateForm(@PathVariable("courseCode") String courseCode, Model model) throws Exception {
        if(courseService.getCourseById(courseCode) == null) {
            throw new IllegalArgumentException("Invalid course Id:" + courseCode);
        }
        Course course = courseService.getCourseById(courseCode);
        model.addAttribute(COURSE_EDIT, course);
        return "edit-course";
    }

    @GetMapping("/delete/{courseCode}")
    public String deleteCourse(@PathVariable("courseCode") String courseCode, Model model) throws Exception {
        try {
            courseService.getCourseById(courseCode);
        } catch (Exception e) {
            throw new Exception();
        }
        courseService.removeCourseById(courseCode);
        model.addAttribute(COURSE, courseService.getAllCourse());
        return "redirect:/seecourse";
    }


    @PostMapping("/update/{courseCode}")
    public String updateCourse(@PathVariable("courseCode") String courseCode, @Valid Course course,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-course";
        }
        courseService.updateCourse(course);
        return "redirect:/seecourse";
    }

    @GetMapping("/assignTA/{courseCode}/{taId}")
    public String deleteCourse(@PathVariable("courseCode") String courseCode, @PathVariable("taId") String taId,
                               Model model) throws Exception {
        courseService.assignTA(courseCode, taId);
        model.addAttribute(COURSE, courseService.getAllCourse());
        return "redirect:/seecourse";
    }
}
