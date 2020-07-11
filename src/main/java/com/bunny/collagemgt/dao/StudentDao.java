package com.bunny.collagemgt.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bunny.collagemgt.model.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {

	Optional<Student> findByEmail(String email);

}
