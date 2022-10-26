package com.example.exercicio5.entities;

import java.util.Objects;

public class Test {
	private Integer id;
	private Double value;

	public Test() {
	}
	
	public Test(Integer id,Double value) {
		this.id = id;
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getId() {
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
		Test other = (Test) obj;
		return Objects.equals(id, other.id);
	}
}
