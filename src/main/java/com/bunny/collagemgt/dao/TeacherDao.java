package com.bunny.collagemgt.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bunny.collagemgt.model.Teacher;

@Repository
public interface TeacherDao extends CrudRepository<Teacher, Integer> {

	Optional<Teacher> findByEmail(String email);

}
