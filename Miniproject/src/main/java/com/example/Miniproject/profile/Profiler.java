package com.example.Miniproject.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Profiler extends JpaRepository<Profile, Integer> {

	Profile findByEmail(String em);
}
