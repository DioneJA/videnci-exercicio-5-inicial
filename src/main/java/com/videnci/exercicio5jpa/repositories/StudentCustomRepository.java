package com.videnci.exercicio5jpa.repositories;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.videnci.exercicio5jpa.entities.Student;
import com.videnci.exercicio5jpa.services.exceptions.ResourceNotFoundException;

@Repository
public class StudentCustomRepository {
	private final EntityManager entityManager;

	public StudentCustomRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked") /* Warning ignorado */
	public Student findStudent(Student students) {
		try {
			List<Object[]> assistent;
			String query = "SELECT tb_student.id, max(test_note), "
					+ "min(test_note), AVG(test_note), "
					+ "COUNT(test_note) FROM "
					+ "tb_student JOIN tb_test ON tb_student.id = tb_test.id_student GROUP BY tb_student.id";
			var q = entityManager.createNativeQuery(query);
			assistent = (List<Object[]>) q.getResultList();
			for (int i = 0; i < assistent.size(); i++) {
				if (((BigInteger) assistent.get(i)[0]).longValue() == students.getId()) {
					students.setHighestGrade((Double) assistent.get(i)[1]);
					students.setLowestGrade((Double) assistent.get(i)[2]);
					students.setAverage((Double) assistent.get(i)[3]);
					students.setAmountTests(((BigInteger) assistent.get(i)[4]).intValue());
				}
			}
			return students;
		}catch (Exception e) {
			throw new ResourceNotFoundException(students.getId());
		}

	}
}
