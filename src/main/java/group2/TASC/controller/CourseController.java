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
    private static final String SCHEDULE = "SCHEDULE";

    @GetMapping("/")
    public String homepage(Model model) {
        return INDEX;
    }

    @GetMapping("/seecourse")
    public String schedulePage(Model model) {
        model.addAttribute(COURSE, courseService.getAllCourse());
        return "see-course";
    }

    @GetMapping("/add/course")
    public String showAddCourseForm(Course course) {
        return "add-course";
    }

    @PostMapping("/addcourse")
    public String addCourse(@Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-course";
        }
        courseService.addCourse(course);
        model.addAttribute(COURSE, courseService.getAllCourse());
        return "redirect:/seecourse";
    }

    @GetMapping("/delete/{courseCode}")
    public String deleteCourse(@PathVariable("courseCode") long courseCode, Model model) throws Exception {
        try {
            courseRepo.findById(courseCode);
        } catch (Exception e) {
            throw new Exception();
        }
        courseService.removeCourseById(courseCode);
        model.addAttribute(COURSE, courseRepo.findAllByOrderByCourseCodeAsc());
        return "redirect:/seecourse";
    }

    @PostMapping("/update/{courseCode}")
    public String updateCourse(@PathVariable("courseCode") long courseCode, @Valid Course course,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            course.setCourseCode(courseCode);
            return "edit-course";
        }
        courseService.updateCourse(course);
        return "redirect:/seecourse";
    }

    @GetMapping("/edit/{courseCode}")
    public String showUpdateForm(@PathVariable("courseCode") long courseCode, Model model) throws Exception {
        if(!courseRepo.existsById(courseCode)) {
            throw new IllegalArgumentException("Invalid user Id:" + courseCode);
        }
        Course course = courseRepo.findByCourseCode(courseCode);
        model.addAttribute(COURSE, course);
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
