package com.deepthought.worker_management_system.repository;
import com.deepthought.worker_management_system.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
}
