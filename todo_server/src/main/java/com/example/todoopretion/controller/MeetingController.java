package com.example.todoopretion.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoopretion.Repository.MeetRepo;
import com.example.todoopretion.entities.Meeting;
import com.example.todoopretion.paylods.ApiResponse;
import com.example.todoopretion.paylods.MeetingDto;
import com.example.todoopretion.serviceimp.MeetingService;

@RestController
@RequestMapping("/api")
public class MeetingController {

	@Autowired
	private MeetingService meetingService;

	// post
	@PostMapping("/employee/{empId}/gym/{gymId}/meeting")
	public ResponseEntity<MeetingDto> createMeeting(@RequestBody MeetingDto meetingDto, @PathVariable Integer empId,
			@PathVariable Integer gymId) {

		MeetingDto res = this.meetingService.createMeeting(meetingDto, empId, gymId);
		return new ResponseEntity<MeetingDto>(res, HttpStatus.CREATED);

	}

	// put
	@PutMapping("/meets/{meetingId}")
	public ResponseEntity<MeetingDto> upadateMeeting(@RequestBody MeetingDto meetingDto,
			@PathVariable Integer meetingId) {
		MeetingDto updateMeet = this.meetingService.updateMeeting(meetingDto, meetingId);
		return new ResponseEntity<>(updateMeet, HttpStatus.OK);

	}

	// getByid
	@GetMapping("/meet/{meetingId}")
	public ResponseEntity<MeetingDto> getMeetingById(@PathVariable Integer meetingId) {
		MeetingDto meet = this.meetingService.getMeeting(meetingId);

		return new ResponseEntity<>(meet, HttpStatus.OK);

	}

	// getAll
	@GetMapping("/meetings")
	public ResponseEntity<List<MeetingDto>> getAllMeet() {
		List<MeetingDto> meets = this.meetingService.getAllMeeting();
		return new ResponseEntity<>(meets, HttpStatus.OK);

	}

	// deteleMeeting

	@DeleteMapping("/meeting/{meetingId}")
	public ResponseEntity<ApiResponse> deteleMeetingById(@PathVariable Integer meetingId) {
		this.meetingService.deleteMeeting(meetingId);
		return new ResponseEntity<>(new ApiResponse("Meeting deleted suceesfully", true), HttpStatus.OK);

	}

	// getMeetingByEmployee
	@GetMapping("/employee/{empId}/meet")
	public ResponseEntity<List<MeetingDto>> getMeetingBYEmployee(@PathVariable Integer empId) {
		List<MeetingDto> out = this.meetingService.getMeetingByEmployee(empId);
		System.out.println(out);
		return new ResponseEntity<List<MeetingDto>>(out, HttpStatus.OK);

	}

	// getMeetingByGym
	@GetMapping("/gym/{gymId}/meeting")
	public ResponseEntity<List<MeetingDto>> getMeetByGym(@PathVariable Integer gymId) {
		List<MeetingDto> meet = this.meetingService.getMeetingBYGym(gymId);
		return new ResponseEntity<>(meet, HttpStatus.OK);

	}

}
