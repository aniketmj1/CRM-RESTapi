package com.mooi.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mooi.dao.TaskHandler;
import com.mooi.entity.TaskEntity;

@RestController
public class TaskRestController {

	@Autowired
	TaskHandler taskHandler;

	@GetMapping("/task")
	public List<TaskEntity> getAllTask() {
		return taskHandler.getAllTasks();
	}

	@PostMapping("/task")
	public TaskEntity addTask(@RequestBody TaskEntity t) {
		return taskHandler.addTask(t);
	}
	@GetMapping("/task/{id}")
	public TaskEntity getTaskById(@PathVariable Long id) {
		return taskHandler.getTask(id);
	}
	@DeleteMapping("/task/{id}")
	public void deleteTaskById(@PathVariable Long id) {
		taskHandler.deleteTask(id);
	}

	@PutMapping("/task/edittask/{id}")
	public void updateTask(@RequestBody TaskEntity t,@PathVariable Long id) {
		
		TaskEntity tempTask= new TaskEntity();
		tempTask.setTaskid(id);
		tempTask.setTittle(t.getTittle());
		tempTask.setAssigned(t.getAssigned());
		tempTask.setCreatedAt(t.getCreatedAt());
		tempTask.setDeadline(t.getDeadline());
		tempTask.setStatus(t.getStatus());
		tempTask.setProject(t.getProject());
		taskHandler.updateTask(tempTask);
	}


}
