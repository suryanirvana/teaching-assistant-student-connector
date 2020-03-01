package group2.TASC.core;

public class Course {
    private Schedule courseSchedule;
    private String courseName;
    private String courseCode;


    public Course(Schedule courseSchedule, String courseName, String courseCode) {
        this.courseSchedule = courseSchedule;
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public Schedule getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(Schedule courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
