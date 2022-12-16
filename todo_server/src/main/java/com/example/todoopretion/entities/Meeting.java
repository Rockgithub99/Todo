package com.example.todoopretion.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "meet")
public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer meetingId;

	private String meetingTitle;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date startDateTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date endDateTime;
	
	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	private Gym gym;
	

}
