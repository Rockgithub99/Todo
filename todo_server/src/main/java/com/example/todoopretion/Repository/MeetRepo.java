package com.example.todoopretion.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoopretion.entities.Employee;
import com.example.todoopretion.entities.Gym;
import com.example.todoopretion.entities.Meeting;

public interface MeetRepo  extends JpaRepository<Meeting,Integer>{
	
	List<Meeting> findByEmployee(Employee employee);
	
	List<Meeting> findByGym(Gym gym);

}
