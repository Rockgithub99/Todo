package com.example.todoopretion.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoopretion.entities.Employee;

public interface EmpRepo extends JpaRepository<Employee,Integer> {
Employee findByStartDateTime(Date startDateTime);
}
