package com.deepthought.worker_management_system.controller;
import com.deepthought.worker_management_system.entity.Worker;
import com.deepthought.worker_management_system.service.WorkerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/workers")
public class WorkerController {
    private final WorkerService workerService;
    public WorkerController(WorkerService workerService){
        this.workerService = workerService;
    }
    @PostMapping
    public Worker createWorker(@RequestBody Worker worker){
        return workerService.saveWorker(worker);
    }
    @GetMapping
    public List<Worker> getAllWorkers(){
        return workerService.getAllWorkers();
    }
    @GetMapping("/{id}")
    public Worker getWorkerById(@PathVariable Long id){
        return workerService.getWorkerById(id);
    }
    @PutMapping("/{id}")
    public Worker updateWorker(@PathVariable Long id,@RequestBody Worker worker){
        return workerService.updateWorker(id,worker);
    }
    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id){
        workerService.deleteWorker(id);
    }
}
