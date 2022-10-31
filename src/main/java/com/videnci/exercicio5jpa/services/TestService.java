package com.videnci.exercicio5jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videnci.exercicio5jpa.entities.Test;
import com.videnci.exercicio5jpa.repositories.TestRepository;

@Service
public class TestService {
	@Autowired
	private TestRepository testRepository;
	
	public void saveTest(Test test) {
		testRepository.save(test);
	}
}
