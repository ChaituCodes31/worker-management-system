package com.deepthought.worker_management_system.repository;
import com.deepthought.worker_management_system.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
}
