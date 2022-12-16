package com.example.todoopretion.serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.todoopretion.paylods.MeetingDto;

@Service
public interface MeetingImp {
	
	MeetingDto createMeeting(MeetingDto meetingDto ,Integer empId,Integer gymId);

	MeetingDto updateMeeting(MeetingDto meetingDto, Integer meetingId);
	
	MeetingDto getMeeting(Integer meetingId);

	List<MeetingDto> getAllMeeting();

	void deleteMeeting(Integer meetingId);
	
	// get all meeting by employee
	List<MeetingDto> getMeetingByEmployee(Integer empId);
	
	// get all meeting by gym
	List<MeetingDto> getMeetingBYGym(Integer gymId);
	

}
