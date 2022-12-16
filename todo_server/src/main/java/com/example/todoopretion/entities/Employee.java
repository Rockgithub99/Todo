package com.example.todoopretion.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "Emp")

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	private String name;
	private String description;
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date startDateTime;
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date endDateTime;
	
	
	@OneToMany(mappedBy="employee",cascade=CascadeType.ALL ,fetch=FetchType.LAZY)
	private List<Meeting> list= new ArrayList<>();
	
	
	
}
