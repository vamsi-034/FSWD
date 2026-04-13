package com.example.Miniproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mpr extends JpaRepository<Mp,Integer> {

	Boolean existsByEmail(String Email);
	
	Mp findByEmail(String Email);
}
