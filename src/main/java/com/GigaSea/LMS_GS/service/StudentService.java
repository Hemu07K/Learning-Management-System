package com.GigaSea.LMS_GS.service;
import com.GigaSea.LMS_GS.model.Student;
import java.util.List;
public interface StudentService {
    void saveStudent(Student student);
    List<Student> findStudents();
    Student getStudentId(Long id);
    void deleteStudent(Long id);
    void deleteAllStudents();
    void addCourseToStudent(Long studentId, Long courseId);
}
