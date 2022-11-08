package com.videnci.exercicio5jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_student")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<Test> tests = new ArrayList<>();
	
	@Transient
	private Double highestGrade;
	@Transient
	private Double lowestGrade;
	@Transient
	private Double average;
	@Transient
	private Integer amountTests;
	
	public Double getHighestGrade() {
		return highestGrade;
	}

	public void setHighestGrade(Double highestGrade) {
		this.highestGrade = highestGrade;
	}

	public Double getLowestGrade() {
		return lowestGrade;
	}

	public void setLowestGrade(Double lowestGrade) {
		this.lowestGrade = lowestGrade;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Integer getAmountTests() {
		return amountTests;
	}

	public void setAmountTests(Integer amountTests) {
		this.amountTests = amountTests;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student() {
	}

	public Student(Long id, String name) {
		this.id = id;
		this.name = name;
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

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Long getId() {
		return id;
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
