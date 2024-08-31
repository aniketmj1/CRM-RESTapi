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

import com.mooi.dao.MeetingHandler;
import com.mooi.entity.MeetingEntity;

@RestController
public class MeetingRestController {
	@Autowired
	MeetingHandler meetingHandler;
	
	@GetMapping("/meeting")
	public List<MeetingEntity> getAllMeeting()
	{
		return meetingHandler.getAllMeeting();
	}
	
	@PostMapping("/meeting")
	public MeetingEntity addMeeting(@RequestBody MeetingEntity me ) 
	{
		meetingHandler.addMeeting(me);
		return me;
		
	}
	@PutMapping("/meeting")
	public MeetingEntity updateMeeting(@RequestBody MeetingEntity me)
	{
		MeetingEntity tempMe = new MeetingEntity();
		
		tempMe.setCustomer(me.getCustomer());
		tempMe.setDate(me.getDate());
		tempMe.setEnd(me.getEnd());
		tempMe.setMeet(me.getMeet());
		tempMe.setStart(me.getStart());
		tempMe.setType(me.getType());
		
		meetingHandler.updateMeeting(tempMe);
		
		
		return tempMe;
	}
	@DeleteMapping("/meeting/{id}")
	public void deleteMeeting(@PathVariable Long id)
	{
		meetingHandler.deleteMeeting(meetingHandler.getById(id));
	}

}
