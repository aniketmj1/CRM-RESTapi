package com.mooi.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mooi.entity.MeetingEntity;




public interface MeetingRepository extends JpaRepository<MeetingEntity, Long>{

	public MeetingEntity  getById(Long id);
}
