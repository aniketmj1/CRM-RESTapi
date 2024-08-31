package com.mooi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooi.entity.MeetingEntity;
import com.mooi.services.MeetingRepository;

@Service
public class MeetingHandler {

	@Autowired
	MeetingRepository meetingRepository;
	
	public MeetingEntity getById(Long id)
	{
		return meetingRepository.getById(id);
	}

	public List<MeetingEntity> getAllMeeting() {

		return meetingRepository.findAll();
	}

	public void addMeeting(MeetingEntity me) {
		meetingRepository.save(me);
	}

	public void updateMeeting(MeetingEntity me) {
		meetingRepository.save(me);
	}
	
	public void deleteMeeting(MeetingEntity me)
	{
		meetingRepository.delete(me);
	}

	

}
