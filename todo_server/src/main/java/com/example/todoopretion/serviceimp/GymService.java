package com.example.todoopretion.serviceimp;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoopretion.Repository.GymRepo;
import com.example.todoopretion.entities.Gym;
import com.example.todoopretion.exception.ResourceNotFoundException;
import com.example.todoopretion.paylods.GymDto;

@Service
public class GymService implements GymImp {
	
	@Autowired
	private GymRepo gymRepo;

	@Autowired
	private ModelMapper modelMapper;

	// create
	@Override
	public GymDto createGym(GymDto gymDto) {
		Gym var=this.modelMapper.map(gymDto, Gym.class);
		Gym res=this.gymRepo.save(var);
		return this.modelMapper.map(res, GymDto.class);
	}

	// update
	@Override
	public GymDto updateGym(GymDto gymDto, Integer gymId) {
		Gym gym=this.gymRepo.findById(gymId).orElseThrow(()-> new ResourceNotFoundException("Gym", "id", gymId));
		gym.setName(gymDto.getName());
		gym.setStartDateTime(gymDto.getStartDateTime());
		gym.setEndDateTime(gymDto.getEndDateTime());
		Gym updateGym=this.gymRepo.save(gym);
		return this.modelMapper.map(updateGym, GymDto.class);
	}

	//getByid
	@Override
	public GymDto getGym(Integer gymId) {
		Gym gym=this.gymRepo.findById(gymId).orElseThrow(()-> new ResourceNotFoundException("Gym", "id", gymId));	
		return this.modelMapper.map(gym, GymDto.class);
	}

	//getbyAll
	@Override
	public List<GymDto> getAllGym() {
		List<Gym> gym1=this.gymRepo.findAll();
		List<GymDto> collect=gym1.stream().map(coll->this.modelMapper.map(coll,GymDto.class)).collect(Collectors.toList());
		return collect;
	}

	// delete
	@Override
	public void deleteGym(Integer gymId) {
		Gym gym=this.gymRepo.findById(gymId).orElseThrow(()-> new ResourceNotFoundException("Gym", "id", gymId));	
		this.gymRepo.delete(gym);
	}
	
	
	

	


	
}
