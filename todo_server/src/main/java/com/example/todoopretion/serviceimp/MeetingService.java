package com.example.todoopretion.serviceimp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoopretion.Repository.EmpRepo;
import com.example.todoopretion.Repository.GymRepo;
import com.example.todoopretion.Repository.MeetRepo;
import com.example.todoopretion.entities.Employee;
import com.example.todoopretion.entities.Gym;
import com.example.todoopretion.entities.Meeting;
import com.example.todoopretion.exception.ResourceNotFoundException;
import com.example.todoopretion.paylods.MeetingDto;

@Service
public class MeetingService implements MeetingImp {
	
	@Autowired
	private MeetRepo meetRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmpRepo empRepo;
	
	@Autowired
	private GymRepo gymRepo;
	
	
	
	
	// create
	@Override
	public MeetingDto createMeeting(MeetingDto meetingDto,Integer empId,Integer gymId) {
		
		Employee emp=this.empRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee","id",empId));
		Gym collect=this.gymRepo.findById(gymId).orElseThrow(()->new ResourceNotFoundException("Gym","id",gymId));
		
		Meeting meet=this.modelMapper.map(meetingDto, Meeting.class);
		
		meet.setEmployee(emp);
		meet.setGym(collect);
		
		Meeting meeting=this.meetRepo.save(meet);
		return this.modelMapper.map(meeting, MeetingDto.class);
	}

	
	// update
	@Override
	public MeetingDto updateMeeting(MeetingDto meetingDto, Integer meetingId) {
		
		Meeting meets=this.meetRepo.findById(meetingId).orElseThrow(()->new ResourceNotFoundException("Meeting","id",meetingId));
		meets.setMeetingTitle(meetingDto.getMeetingTitle());
		meets.setStartDateTime(meetingDto.getStartDateTime());
		meets.setEndDateTime(meetingDto.getEndDateTime());
		Meeting meet=this.meetRepo.save(meets);
		return this.modelMapper.map(meet, MeetingDto.class);
	}

	
	// get
	@Override
	public MeetingDto getMeeting(Integer meetingId) {
		 Meeting meet=this.meetRepo.findById(meetingId).orElseThrow(()->new ResourceNotFoundException("Meeting","id", meetingId));
		return this.modelMapper.map(meet, MeetingDto.class);
	}

	// getAll
	@Override
	public List<MeetingDto> getAllMeeting() {
		List<Meeting> meetAll=this.meetRepo.findAll();
		List<MeetingDto> meetDto=meetAll.stream().map(meet->this.modelMapper.map(meet, MeetingDto.class)).collect(Collectors.toList());
		
		return meetDto;
	}
	
	// getAll

	@Override
	public void deleteMeeting(Integer meetingId) {
		this.meetRepo.deleteById(meetingId);
		
		
	}

	// getAllMeeting By Employee
	@Override
	public List<MeetingDto> getMeetingByEmployee(Integer empId) {
		
		Employee emp=this.empRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee","id",empId));
		List<Meeting> meet=this.meetRepo.findByEmployee(emp);
		List<MeetingDto>meetDto= meet.stream().map(meets->this.modelMapper.map(meets, MeetingDto.class)).collect(Collectors.toList());
		
		return meetDto;
	}

	// getAllMeeting by Gym
	@Override
	public List<MeetingDto> getMeetingBYGym(Integer gymId) {
		Gym res=this.gymRepo.findById(gymId).orElseThrow(()->new ResourceNotFoundException("GymId","id",gymId));
		List<Meeting> meeting=this.meetRepo.findByGym(res);
		List<MeetingDto> meetingDto=meeting.stream().map(meets->this.modelMapper.map(meets, MeetingDto.class)).collect(Collectors.toList());
		return meetingDto;
	}

}
