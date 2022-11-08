package com.videnci.exercicio5jpa.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.videnci.exercicio5jpa.entities.Test;
import com.videnci.exercicio5jpa.repositories.TestCustomRepository;
import com.videnci.exercicio5jpa.repositories.TestRepository;
import com.videnci.exercicio5jpa.services.exceptions.DataBaseException;
import com.videnci.exercicio5jpa.services.exceptions.ResourceNotFoundException;

@Service
public class TestService {
	@Autowired
	private TestRepository testRepository;

	@Autowired
	private TestCustomRepository customRepository;

	public List<Test> findAll() {
		return testRepository.findAll();
	}

	public List<Test> findAllByStudentId(Long id) {
		return customRepository.findAllByStudentId(id);
	}

	public Test findById(Long id) {
		return testRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Test saveTest(Test test) {
		return testRepository.save(test);
	}

	public void deleteTest(Long id) {
		try {
			testRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Test updateTest(Long id, Test test) {
		try {
			@SuppressWarnings("deprecation")
			Test entity = testRepository.getById(id);
			updatedData(entity, test);
			return testRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updatedData(Test entity, Test test) {
		entity.setValue(test.getValue());
	}
}
