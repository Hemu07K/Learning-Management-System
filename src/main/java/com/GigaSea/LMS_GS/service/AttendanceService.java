package com.GigaSea.LMS_GS.service;
import com.GigaSea.LMS_GS.model.Attendance;
import java.util.List;

public interface AttendanceService {
    void saveAttendance(Attendance attendance);
    List<Attendance> findAttendances();
    Attendance getAttendanceId(Long id);
    void deleteAttendance(Long id);
    void deleteAllAttendances();// New method
}
