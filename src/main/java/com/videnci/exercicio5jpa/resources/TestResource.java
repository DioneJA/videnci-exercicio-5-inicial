package com.videnci.exercicio5jpa.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.videnci.exercicio5jpa.entities.Test;
import com.videnci.exercicio5jpa.services.TestService;

@RestController
@RequestMapping("/api/test")
public class TestResource {
	@Autowired
	TestService testService;

	@GetMapping
	public ResponseEntity<List<Test>> findAll() {
		return ResponseEntity.ok(testService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Test> findById(@PathVariable Long id) {
		return ResponseEntity.ok(testService.findById(id));
	}
	
	@GetMapping(value = "/highest")
	public ResponseEntity<Double> highestScore(){
		return ResponseEntity.ok(testService.highestScore());
	}

	@GetMapping(value = "/student/{id}")
	public ResponseEntity<List<Test>> findAllByStudentId(@PathVariable Long id) {
		return ResponseEntity.ok(testService.findAllByStudentId(id));
	}

	@PostMapping
	public ResponseEntity<Test> saveTest(@RequestBody Test test) {
		test = testService.saveTest(test);
		testService.saveTest(test);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(test.getId()).toUri();
		return ResponseEntity.created(uri).body(test);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
		testService.deleteTest(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Test> updatedTest(@PathVariable Long id, @RequestBody Test test) {
		test = testService.updateTest(id, test);
		return ResponseEntity.ok(test);

	}
}
