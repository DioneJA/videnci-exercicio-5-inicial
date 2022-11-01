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

import com.videnci.exercicio5jpa.entities.Student;
import com.videnci.exercicio5jpa.services.StudentService;

@RestController
@RequestMapping("/api")
public class StudentResource {
	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/find/student/{id}")
	public ResponseEntity<Student> findStudent(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.findStudent(studentService.findById(id)));
	}

	@GetMapping(value = "/find/student/all")
	public ResponseEntity<List<Student>> findAll() {
		return ResponseEntity.ok(studentService.findAll());
	}

	@PostMapping(value = "/save/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		student = studentService.saveStudent(student);
		studentService.saveStudent(student);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/save/student/{id}").buildAndExpand(student.getId())
				.toUri();
		return ResponseEntity.created(uri).body(student);
	}

	@DeleteMapping(value = "/delete/student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/updated/student/{id}")
	public ResponseEntity<Student> updatedStudent(@PathVariable Long id, @RequestBody Student student) {
		student = studentService.updateStudent(id, student);
		return ResponseEntity.ok(student);

	}
}