package com.example.todoopretion.controller;

import java.text.ParseException;
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

import com.example.todoopretion.paylods.ApiResponse;
import com.example.todoopretion.paylods.EmployeeDto;
import com.example.todoopretion.paylods.GymDto;
import com.example.todoopretion.serviceimp.GymService;

@RestController
@RequestMapping("/api/gym")
public class GymController {

	@Autowired
	private GymService gymService;

	// create
	@PostMapping("/")
	public ResponseEntity<GymDto> createNewGym(@RequestBody GymDto gymDto) {
		GymDto createDto = this.gymService.createGym(gymDto);
		return new ResponseEntity<>(createDto, HttpStatus.CREATED);

	}

	// put
	@PutMapping("/{gymId}")
	public ResponseEntity<GymDto> updateNewGym(@RequestBody GymDto gymDto, @PathVariable Integer gymId) {
		GymDto upadteGym = this.gymService.updateGym(gymDto, gymId);
		return new ResponseEntity<>(upadteGym, HttpStatus.OK);
	}

	// get
	@GetMapping("/{gymId}")
	public ResponseEntity<GymDto> getNewGym(@PathVariable Integer gymId){
		GymDto collect=this.gymService.getGym(gymId);
		return new ResponseEntity<>(collect,HttpStatus.FOUND);
		
	}
	
	// getAll
	
	@GetMapping("/All")
	public  ResponseEntity<List<GymDto>> getAllNewGym(){
		List<GymDto> collect2=this.gymService.getAllGym();
		return new ResponseEntity<>(collect2,HttpStatus.OK);
		
	}
	

	// delete
	@DeleteMapping("/{gymId}")
	public ResponseEntity<ApiResponse> deleteGym(@PathVariable Integer gymId) {
		this.gymService.deleteGym(gymId);
		return new ResponseEntity<>(new ApiResponse("Gym deleted suceessfully", true), HttpStatus.OK);

	}
	

}
