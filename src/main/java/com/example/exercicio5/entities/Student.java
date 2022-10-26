package com.example.exercicio5.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
	private Integer id;
	private String name;
	private Double highestGrade;
	private Double lowestGrade;
	private Double average;
	private Integer amountTests;

	private List<Test> tests = new ArrayList<>();

	public Student() {

	}

	public Student(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Student(Integer id, String name, Double highestGrade, Double lowestGrade, Double average,
			Integer amountTests, List<Test> tests) {
		this.id = id;
		this.name = name;
		this.highestGrade = highestGrade;
		this.lowestGrade = lowestGrade;
		this.average = average;
		this.amountTests = amountTests;
		this.tests = tests;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Test> getTests() {
		return tests;
	}

	public Double getHighestGrade() {
		return highestGrade;
	}

	public Double getLowestGrade() {
		return lowestGrade;
	}

	public Double getAverage() {
		return average;
	}

	public Integer getAmountTests() {
		return amountTests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Integer getId() {
		return id;
	}

	/* Adicionar um teste na lista de testes */
	public void addTest(Test test) {
		tests.add(test);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}
}
