package com.videnci.exercicio5jpa.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.videnci.exercicio5jpa.entities.Student;
import com.videnci.exercicio5jpa.repositories.StudentCustomRepository;
import com.videnci.exercicio5jpa.repositories.StudentRepository;
import com.videnci.exercicio5jpa.services.exceptions.DataBaseException;
import com.videnci.exercicio5jpa.services.exceptions.ResourceNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentCustomRepository customRepository;

	public Student findStudent(Student student) {
		return customRepository.findStudent(student);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public Student findById(Long id) {
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		try {
			studentRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Student updateStudent(Long id, Student student) {
		try {
			@SuppressWarnings("deprecation")
			Student entity = studentRepository.getById(id);
			updatedData(entity, student);
			return studentRepository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	
	}

	private void updatedData(Student entity, Student student) {
		entity.setName(student.getName());
		entity.setTests(student.getTests());

	}

}
