package com.mooi.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaskEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskid;
	
	private String tittle;
	private String assigned;
	private String project;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDateTime deadline;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDateTime createdAt;
	private String status;
	
	
	
	public String getTittle() {
		return tittle;
	}



	public void setTittle(String tittle) {
		this.tittle = tittle;
	}



	public String getAssigned() {
		return assigned;
	}



	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}



	public String getProject() {
		return project;
	}



	public void setProject(String project) {
		this.project = project;
	}



	public LocalDateTime getDeadline() {
		return deadline;
	}



	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Long getTaskid() {
		return taskid;
	}



	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}



	@Override
	public String toString() {
		return "TaskEntity [taskid=" + taskid + ", tittle=" + tittle + ", assigned=" + assigned + ", project=" + project
				+ ", deadline=" + deadline + ", createdAt=" + createdAt + ", status=" + status + "]";
	}
	
	
	

	

}
