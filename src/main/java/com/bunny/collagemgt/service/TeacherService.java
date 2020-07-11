package com.bunny.collagemgt.service;

import java.util.Optional;

import com.bunny.collagemgt.model.Teacher;
import com.bunny.collagemgt.model.dto.TeacherLoginDto;
import com.bunny.collagemgt.model.dto.TeacherRegisterDto;

public interface TeacherService {

	public boolean registerTeacher(TeacherRegisterDto request);

	public Optional<Teacher> login(TeacherLoginDto request);

}
