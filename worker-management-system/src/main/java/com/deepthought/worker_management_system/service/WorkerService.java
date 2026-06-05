package com.deepthought.worker_management_system.service;
import com.deepthought.worker_management_system.entity.Worker;
import com.deepthought.worker_management_system.exception.ResourceNotFoundException;
import com.deepthought.worker_management_system.repository.WorkerRepository;
import com.deepthought.worker_management_system.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkerService {
     private final WorkerRepository workerRepository;
     public WorkerService(WorkerRepository workerRepository){
         this.workerRepository=workerRepository;
     }
     public Worker saveWorker(Worker worker){
         return workerRepository.save(worker);
     }
     public List<Worker> getAllWorkers(){
         return workerRepository.findAll();
     }
     public Worker getWorkerById(Long id){
         return workerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Worker not found with id:" + id));
     }
     public Worker updateWorker(Long id, Worker workerDetails){
         Worker worker = workerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Worker not found with id: " + id));
             worker.setName(workerDetails.getName());
             worker.setDepartment(workerDetails.getDepartment());
             worker.setHourlyRate(workerDetails.getHourlyRate());
             return workerRepository.save(worker);

     }
     public void deleteWorker(Long id){
         Worker worker = workerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Worker not found with id: " + id));
         workerRepository.delete(worker);
     }
}
