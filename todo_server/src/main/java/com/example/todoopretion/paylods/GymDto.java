package com.example.todoopretion.paylods;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class GymDto {
	private Integer gymId;
	private String name;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date startDateTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date endDateTime;

}
