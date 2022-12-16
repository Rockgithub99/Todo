package com.example.todoopretion.serviceimp;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todoopretion.paylods.EmployeeDto;

@Service
public interface EmpImp {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto updateEmployee(EmployeeDto employeeDto,Integer empId);
	
	EmployeeDto getEmployeeAttendsReports( String startDateTime) throws ParseException;
	
	
	List<EmployeeDto> getAllEmployee();
	
	void deleteEmployee(Integer empId);
	

}
