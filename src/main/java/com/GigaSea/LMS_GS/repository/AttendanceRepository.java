package com.GigaSea.LMS_GS.repository;

import com.GigaSea.LMS_GS.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long>{
}