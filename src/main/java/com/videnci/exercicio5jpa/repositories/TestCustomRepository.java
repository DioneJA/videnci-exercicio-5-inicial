package com.videnci.exercicio5jpa.repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.videnci.exercicio5jpa.entities.Test;

@Repository
public class TestCustomRepository {
	private final EntityManager entityManager;

	public TestCustomRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked") /* Warning ignorado */
	public List<Test> findAllByStudentId(Long id) {
		try {
			
			List<Object[]> assistent;
			List<Test> tests = new ArrayList<>();
			String query = "SELECT * from tb_test WHERE id_student = " + id;
			var q = entityManager.createNativeQuery(query);
			assistent = (List<Object[]>) q.getResultList();
			for (int i = 0; i < assistent.size(); i++) {
				Long assistentId = ((BigInteger) assistent.get(i)[0]).longValue();
				Double assistentValue = (Double) assistent.get(i)[1];
				tests.add(new Test(assistentId, assistentValue, null));
			}
			return tests;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Double highestScore() {
		try {
			String query = "SELECT MAX(test_note) FROM tb_test";
			var q = entityManager.createNativeQuery(query);
			return (Double) q.getSingleResult();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
