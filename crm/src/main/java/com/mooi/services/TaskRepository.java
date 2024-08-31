package com.mooi.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mooi.entity.TaskEntity;

@Service
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
	
	public TaskEntity findByTaskid (Long taskId);
	
	

}
