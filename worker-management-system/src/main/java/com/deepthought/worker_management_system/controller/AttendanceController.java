package com.deepthought.worker_management_system.controller;
import com.deepthought.worker_management_system.entity.Attendance;
import com.deepthought.worker_management_system.service.AttendanceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;
    public AttendanceController(AttendanceService attendanceService){
        this.attendanceService = attendanceService;
    }
    @PostMapping
    public Attendance createAttendance(@RequestBody Attendance attendance){
        return attendanceService.saveAttendance(attendance);
    }
    @GetMapping
    public List<Attendance> getAllAttendance(){
        return attendanceService.getAllAttendance();
    }
    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance){
        return attendanceService.updateAttendance(id,attendance);
    }
    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id){
        attendanceService.deleteAttendance(id);
    }
}
