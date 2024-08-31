package com.mooi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mooi.entity.MeetingEntity;
import com.mooi.restcontrollers.MeetingRestController;

@Controller
public class MeetingController {
	@Autowired
	MeetingRestController meetingRestController;
	
	
	@GetMapping("/meetings")
	public String allMeeting(Model m)
	{
		m.addAttribute("meeting",meetingRestController.getAllMeeting());
		
		return "meeting";
	}
	
	@GetMapping("/meetings/add")
	public String addMeeting()
	{
		return "addmeeting";
	}
	
	
	@PostMapping("/meetings/add")
	public String saveMeeting(@ModelAttribute("meeting") MeetingEntity m)
	{
		meetingRestController.addMeeting(m);
		return "rediret:/meeting";
	}
	
	
	@GetMapping("/meetings/{id}")
	public String deleteMeeting(@PathVariable("id") Long id ) {
		meetingRestController.deleteMeeting(id);
		return "rediret:/meeting";
	}

}
