package com.GigaSea.LMS_GS.controller;

import com.GigaSea.LMS_GS.model.Attendance;
import com.GigaSea.LMS_GS.model.Student;
import com.GigaSea.LMS_GS.service.AttendanceService;
import com.GigaSea.LMS_GS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/attendance/mark")
    public String showMarkAttendanceForm(Model model) {
        model.addAttribute("attendance", new Attendance());
        return "markAttendance";
    }

    @PostMapping("/attendance/save")
    public String saveAttendance(@ModelAttribute Attendance attendance) {
        attendanceService.saveAttendance(attendance);
        return "redirect:/attendance/view";
    }

    @GetMapping("/attendance/view")
    public String viewAttendance(Model model) {
        List<Student> students = studentService.findStudents();
        Map<Long, String> studentNames = students.stream()
                .collect(Collectors.toMap(
                        Student::getId,
                        student -> student.getFirstname() + " " + student.getLastname()
                ));

        List<Attendance> attendances = attendanceService.findAttendances();
        attendances.forEach(attendance -> attendance.setStudentName(studentNames.get(attendance.getStudentId())));

        model.addAttribute("attendances", attendances);
        return "viewAttendance";
}
}