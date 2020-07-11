package com.bunny.collagemgt.service;

import java.util.Optional;

import com.bunny.collagemgt.model.Student;
import com.bunny.collagemgt.model.dto.StudentLoginDto;
import com.bunny.collagemgt.model.dto.StudentRegisterDto;

public interface StudentService {

	public boolean registerStudent(StudentRegisterDto request);

	public Optional<Student> login(StudentLoginDto request);

}
