package com.GigaSea.LMS_GS.service;
import com.GigaSea.LMS_GS.model.Course;
import java.util.List;
public interface CourseService {
    void saveCourse(Course course);
    List<Course> findCourses();
    Course getCourseId(Long id);
    void deleteCourse(Long id);
    void deleteAllCourses();
}
