package com.example.todoopretion.serviceimp;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todoopretion.exception.*;
import com.example.todoopretion.Repository.EmpRepo;
import com.example.todoopretion.entities.Employee;
import com.example.todoopretion.paylods.EmployeeDto;

@Service
public class EmpService implements EmpImp {
	@Autowired
	private EmpRepo empRepo;

	@Autowired
	private ModelMapper modelMapper;

	//Post
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = this.dtoToEmployee(employeeDto);
		System.out.println(employee);
		
		Employee savedEmploye = this.empRepo.save(employee);

		return this.employeeToDto(savedEmploye);
	}

	// put
	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer empId) {
		Employee employee = this.empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));

		employee.setName(employeeDto.getName());
		employee.setDescription(employeeDto.getDescription());
		employee.setStartDateTime(employeeDto.getStartDateTime());
		employee.setStartDateTime(employeeDto.getEndDateTime());
		Employee updateEmp = this.empRepo.save(employee);
		EmployeeDto empDto = this.employeeToDto(updateEmp);
		return empDto;
	}

	//get
	@Override
	public EmployeeDto getEmployeeAttendsReports(String startDateTime) throws ParseException {
	
		
	    Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDateTime);  
	    Employee employee =  this.empRepo.findByStartDateTime(date1);
				
        System.out.println(employee);
		//return this.employeeToDto(employee);
		return null;
		
	}

	

	// getall
	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> emp=this.empRepo.findAll();
		List<EmployeeDto> employeeDto=emp.stream().map(employee->this.employeeToDto(employee)).collect(Collectors.toList());

		return employeeDto;
	}

	@Override
	public void deleteEmployee(Integer empId) {
		Employee employee = this.empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
		
		this.empRepo.delete(employee);

	}

	
	
	
	public Employee dtoToEmployee(EmployeeDto employeeDto) {
		Employee emp = this.modelMapper.map(employeeDto, Employee.class);
		return emp;

	}

	public EmployeeDto employeeToDto(Employee employee) {
		EmployeeDto empDto = this.modelMapper.map(employee, EmployeeDto.class);
		return empDto;

	}

}
