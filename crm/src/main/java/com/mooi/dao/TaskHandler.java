package com.mooi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mooi.entity.TaskEntity;
import com.mooi.services.TaskRepository;

@Component
public class TaskHandler {
	
	
	@Autowired
	TaskRepository taskRepository;
	
	
	public List<TaskEntity> getAllTasks()
	{
		return this.taskRepository.findAll();
	}
	
	public TaskEntity getTask(Long id) 
	{
		return taskRepository.findByTaskid(id);
	}

	public void deleteTask(Long id)
	{
		taskRepository.delete(getTask(id));
			
	}
	
	public TaskEntity addTask(TaskEntity t) 
	{
		return  this.taskRepository.save(t);
	}
	
	public void updateTask (TaskEntity t)
	{
		
//		TaskEntity tempTask = getTask(t.getTaskid());
//		
//		tempTask.setTittle(t.getTittle());
//		tempTask.setAssigned(t.getAssigned());
//		tempTask.setCreatedAt(t.getCreatedAt());
//		tempTask.setDeadline(t.getDeadline());
//		tempTask.setStatus(t.getStatus());
//		tempTask.setProject(t.getProject());
		taskRepository.save(t);
		
	}
	
}
