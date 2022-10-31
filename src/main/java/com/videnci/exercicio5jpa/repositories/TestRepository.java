package com.videnci.exercicio5jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videnci.exercicio5jpa.entities.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Long>{
}
