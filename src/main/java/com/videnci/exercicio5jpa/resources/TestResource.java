package com.videnci.exercicio5jpa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videnci.exercicio5jpa.entities.Test;
import com.videnci.exercicio5jpa.services.TestService;

@RestController
@RequestMapping("/api")
public class TestResource {
	@Autowired
	TestService testService;

	@PostMapping(name = "/test")
	public void saveTest(@RequestBody Test test) {
		testService.saveTest(test);
	}
}
