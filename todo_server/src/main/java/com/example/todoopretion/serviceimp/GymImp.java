package com.example.todoopretion.serviceimp;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todoopretion.paylods.GymDto;

@Service
public interface GymImp {

	GymDto createGym(GymDto gymDto);

	GymDto updateGym(GymDto gymDto, Integer gymId);
	
	GymDto getGym(Integer gymId);

	List<GymDto> getAllGym();

	void deleteGym(Integer gymId);
 
	
}
