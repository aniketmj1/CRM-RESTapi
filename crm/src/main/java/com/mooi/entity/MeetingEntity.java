package com.mooi.entity;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MeetingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date date;
	private String meet;
	private Time start;
	private Time end;
	private String customer;
	private String type;
	
	
	
	public Long getId() {
		return id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMeet() {
		return meet;
	}
	public void setMeet(String meet) {
		this.meet = meet;
	}
	public Time getStart() {
		return start;
	}
	public void setStart(Time start) {
		this.start = start;
	}
	public Time getEnd() {
		return end;
	}
	public void setEnd(Time end) {
		this.end = end;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "MeetingEntity [id=" + id + ", date=" + date + ", meet=" + meet + ", start=" + start + ", end=" + end
				+ ", customer=" + customer + ", type=" + type + "]";
	}
	
	
}
