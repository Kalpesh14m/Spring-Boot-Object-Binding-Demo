package com.bunny.collagemgt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bunny.collagemgt.model.Student;
import com.bunny.collagemgt.model.dto.StudentLoginDto;
import com.bunny.collagemgt.model.dto.StudentRegisterDto;
import com.bunny.collagemgt.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/register")
	public String register(@RequestBody StudentRegisterDto request) {
		if (studentService.registerStudent(request)) {
			return "Welcome " + request.getName();
		} else {
			return request.getName() + " Sorry Not register";
		}
	}

	@PostMapping("/login")
	public String login(@RequestBody StudentLoginDto request) {
		Optional<Student> maybeStudent = studentService.login(request);
		return "Login Successfull: " + maybeStudent.get().getName();
	}

}
