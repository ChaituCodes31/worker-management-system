package com.deepthought.worker_management_system.service;
import com.deepthought.worker_management_system.exception.ResourceNotFoundException;
import com.deepthought.worker_management_system.repository.AttendanceRepository;
import com.deepthought.worker_management_system.entity.Attendance;
import com.deepthought.worker_management_system.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    public AttendanceService(AttendanceRepository attendanceRepository){
        this.attendanceRepository = attendanceRepository;
    }
    public Attendance saveAttendance(Attendance attendance){
        return attendanceRepository.save(attendance);
    }
    public List<Attendance> getAllAttendance(){
        return attendanceRepository.findAll();
    }
    public Attendance getAttendanceById(Long id){
        return attendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attendance not found with id: "+ id));
    }
    public Attendance updateAttendance(Long id,Attendance attendanceDetails){
        Attendance attendance=attendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attendance not found with id: " +id));
            attendance.setWorkerId(attendanceDetails.getWorkerId());
            attendance.setCheckIn(attendanceDetails.getCheckIn());
            attendance.setCheckOut(attendanceDetails.getCheckOut());
            return attendanceRepository.save(attendance);
    }
    public void deleteAttendance(Long id ){
        Attendance attendance = attendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attendance not found with id: " + id));
        attendanceRepository.delete(attendance);
    }

}
