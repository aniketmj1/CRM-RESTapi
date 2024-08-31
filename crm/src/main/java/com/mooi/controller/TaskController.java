package com.mooi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mooi.entity.TaskEntity;
import com.mooi.restcontrollers.TaskRestController;

@Controller
public class TaskController {
	
	@Autowired
	TaskRestController taskRestController;
	
	@GetMapping("/tasks")
	public String tasks(Model m) 
	{
		m.addAttribute("tasks",taskRestController.getAllTask());
		return "tasks";
	}
	@GetMapping("/tasks/addtask")
	public String addTask(Model m)
	{
		TaskEntity task = new TaskEntity();
		m.addAttribute("task",task);
		return "addtask";
	}
	@PostMapping("/tasks/addtask")
	public String saveAddTask(@ModelAttribute ("task") TaskEntity newTask)
	{
		taskRestController.addTask(newTask);
		return "redirect:/tasks";
		
	}
	@GetMapping("/tasks/taskprofile")
	public String taskProfile()
	{
		return "taskprofile";
	}
	
	@GetMapping("/tasks/showtaskprofile/{id}")
	public String showTaskProfile(@PathVariable Long id, Model m)
	{
		//TaskEntity taskProfile = new TaskEntity();
		
		m.addAttribute("taskprofile",taskRestController.getTaskById(id));
		return "showtaskprofile";
	}
	
	@GetMapping("/tasks/{id}")
	public String deleteTask(@PathVariable Long id)
	{
		taskRestController.deleteTaskById(id);
		return "redirect:/tasks";
	}

	@GetMapping("/tasks/edittask/{id}")
	public String editTask(@PathVariable Long id, Model m)
	{
		m.addAttribute("task",taskRestController.getTaskById(id));
		return "edittaskprofile";
	}
	@PostMapping("/tasks/edittask/{id}")
	public String saveEditTask(@ModelAttribute ("task") TaskEntity t,@PathVariable Long id)
	{
		//System.out.println(t.getTaskid());
		taskRestController.updateTask(t,id);
		System.out.println(t);
		return "redirect:/tasks";
	}


}
