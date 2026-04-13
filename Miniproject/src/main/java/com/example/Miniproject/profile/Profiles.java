package com.example.Miniproject.profile;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Profiles {
	@Autowired
	Profiler pr;
	
	public void insert(Profile p) {
		pr.save(p);
	}

	public Profile getUserById(int id) {
        Optional<Profile> user = pr.findById(id);
        return user.orElse(null);
    }

	public Profile findByEmail(String em) {
		// TODO Auto-generated method stub
		return pr.findByEmail(em);
	}
}
