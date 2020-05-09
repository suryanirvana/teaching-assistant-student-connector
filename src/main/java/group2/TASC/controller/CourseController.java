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
        model.addAttribute(COURSE, courseService.getAllCourse());
        return INDEX;
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
        courseRepo.save(course);
        courseService.addCourse(course);
        model.addAttribute(COURSE, courseService.getAllCourse());
        return "see-course";
    }

    @GetMapping("/delete/{courseCode}")
    public String deleteCourse(@PathVariable("courseCode") long courseCode, Model model) throws Exception {
        try {
            courseRepo.findById(courseCode);
        } catch (Exception e) {
            throw new Exception();
        }
        courseRepo.deleteById(courseCode);
        courseService.removeCourseById(courseCode);
        model.addAttribute(COURSE, courseRepo.findAllByOrderByCourseCodeAsc());
        return INDEX;
    }

    @PostMapping("/update/{courseCode}")
    public String updateCourse(@PathVariable("courseCode") long courseCode, @Valid Course course,
                             BindingResult result, Model model) {
        Course updatedCourse = new Course();
        updatedCourse.setCourseCode(updatedCourse.getCourseCode());
        updatedCourse.setCourseName(updatedCourse.getCourseName());
        if (result.hasErrors()) {
            updatedCourse.setCourseCode(courseCode);
            return "update-course";
        }
        courseRepo.save(updatedCourse);
        model.addAttribute(COURSE, courseRepo.findAllByOrderByCourseCodeAsc());
        return INDEX;
    }
}
