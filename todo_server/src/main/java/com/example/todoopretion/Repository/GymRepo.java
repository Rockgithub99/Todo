package com.example.todoopretion.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoopretion.entities.Gym;

public interface GymRepo extends JpaRepository<Gym,Integer> {
	
}
