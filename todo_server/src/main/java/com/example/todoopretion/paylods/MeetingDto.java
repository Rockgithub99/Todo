package com.example.todoopretion.paylods;

import java.util.Date;

import javax.persistence.ManyToOne;

import com.example.todoopretion.entities.Employee;
import com.example.todoopretion.entities.Gym;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MeetingDto {
	
	private String meetingTitle;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date startDateTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date endDateTime;
	
	
	private EmployeeDto employee;
	
	
	private GymDto gym;

}
