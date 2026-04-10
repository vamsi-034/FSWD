package com.example.Miniproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mps {
	@Autowired
	Mpr m;
	
	public void insert(Mp a) {
		m.save(a);
	}

	public boolean existsByEmail(String em) {
		// TODO Auto-generated method stub
		return m.existsByEmail(em);
	}

	public Mp findByEmail(String em) {
		// TODO Auto-generated method stub
		return m.findByEmail(em);
	}

}
