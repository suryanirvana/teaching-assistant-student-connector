package group2.TASC.controller;

import group2.TASC.model.Course;
import group2.TASC.repository.CourseRepo;
import group2.TASC.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CourseController {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseService courseService;

    private static final String INDEX = "index";
    private static final String REDIRECT = "redirect:/";
    private static final String COURSE = "COURSE";

    @GetMapping("/")
    public String homepage(Model model) {
//        model.addAttribute(COURSE, courseService.getAllCourse());
        return INDEX;
    }

    @GetMapping("/add/course")
    public String showAddCourseForm(Course course) {
        return "add-course";
    }

    @PostMapping("/addcourse")
    public String addUser(@Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-course";
        }
        courseRepo.save(course);
        model.addAttribute(COURSE, courseService.getAllCourse());
        return "see-course";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) throws Exception {
        try {
            courseRepo.findById(id);
        } catch (Exception e) {
            throw new Exception();
        }
        courseRepo.deleteById(id);
        model.addAttribute(COURSE, courseRepo.findAllByOrderByCourseCodeAsc());
        return "see-course";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) throws Exception {
        try {
            courseRepo.findById(id);
        } catch (Exception e) {
            throw new Exception();
        }
//        Course course = courseRepo.findByCourseCode(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute(COURSE, courseRepo.findAllByOrderByCourseCodeAsc());
        return "edit-course";
    }

//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") long id, @Valid Course course,
//                             BindingResult result, Model model) {
//        Course updatedCourse = new Course();
//        updatedCourse.setCourseCode(updatedCourse.getCourseCode());
//        updatedCourse.setCourseName(updatedCourse.getCourseName());
//        if (result.hasErrors()) {
//            updatedCourse.setCourseCode(id);
//            return "edit-course";
//        }
//        courseRepo.save(updatedCourse);
//        model.addAttribute(COURSE, courseRepo.findAllByOrderByCourseCodeAsc());
//        return INDEX;
//    }
}
