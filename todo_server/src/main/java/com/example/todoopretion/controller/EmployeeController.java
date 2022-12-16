package com.example.todoopretion.controller;

import java.text.ParseException;
import java.util.Date;
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
import com.example.todoopretion.serviceimp.EmpService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmpService empService;
	
	// Post
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto  createDto=this.empService.createEmployee(employeeDto);
		return new ResponseEntity<>(createDto,HttpStatus.CREATED);
		
	}
	
	
	//put
	@PutMapping("/{empId}")
	public ResponseEntity<EmployeeDto> updateEmp(@RequestBody EmployeeDto employeeDto,@PathVariable Integer empId){
		EmployeeDto updateEmp=this.empService.updateEmployee(employeeDto, empId);
		return new ResponseEntity<EmployeeDto>(updateEmp,HttpStatus.OK);
		
	}
	
	
	// get
	@GetMapping("/{startDateTime}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable String startDateTime) throws ParseException {
		EmployeeDto emp=this.empService.getEmployeeAttendsReports( startDateTime);
		return new ResponseEntity<EmployeeDto>(emp,HttpStatus.FOUND);
		
	}
	
	
	// getall
	
	@GetMapping("/Emp")
	public ResponseEntity<List<EmployeeDto>> getAllEmp(){
		List<EmployeeDto> allEmp=this.empService.getAllEmployee();
		return  ResponseEntity.ok(allEmp);
		
	}
	
	@DeleteMapping("/{empId}")
	public  ResponseEntity<ApiResponse> deleteEmp(@PathVariable Integer empId ){
		this.empService.deleteEmployee(empId);
		return new ResponseEntity(new ApiResponse("Employee deleted sucessfully" ,true),HttpStatus.OK);
	}
	

}
