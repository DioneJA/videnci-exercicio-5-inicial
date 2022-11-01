/*package com.videnci.exercicio5jpa.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.videnci.exercicio5jpa.entities.Student;
import com.videnci.exercicio5jpa.entities.Test;
import com.videnci.exercicio5jpa.repositories.StudentRepository;
import com.videnci.exercicio5jpa.repositories.TestRepository;

@Configuration
public class TestConfig  implements CommandLineRunner{

	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Student student = new Student(null,"Bruno Dionísio Alves");
		Student student2 = new Student(null,"Videnci");
		studentRepository.save(student);
		studentRepository.save(student2);
		
		List<Test> tests = new ArrayList<>();
		tests.add(new Test(null, 10D, student));
		tests.add(new Test(null,6D, student));
		tests.add(new Test(null,10D,student2));
		tests.add(new Test(null,9.5D,student2));
		
		testRepository.saveAll(tests);
	}

}*/
