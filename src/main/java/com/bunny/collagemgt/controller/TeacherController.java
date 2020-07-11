package com.bunny.collagemgt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bunny.collagemgt.model.Teacher;
import com.bunny.collagemgt.model.dto.TeacherLoginDto;
import com.bunny.collagemgt.model.dto.TeacherRegisterDto;
import com.bunny.collagemgt.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@PostMapping("/register")
	public String register(@RequestBody TeacherRegisterDto request) {
		if (teacherService.registerTeacher(request)) {
			return "Welcome Teacher: " + request.getName();
		} else {
			return request.getName() + " Sorry Not register";
		}
	}

	@PostMapping("/login")
	public String login(@RequestBody TeacherLoginDto request) {
		Optional<Teacher> maybeTeacher = teacherService.login(request);
		return "Login Successfull: " + maybeTeacher.get().getName() + " Sir.";
	}

}