package com.bunny.collagemgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bunny.collagemgt.model.Department;
import com.bunny.collagemgt.model.dto.DepartmentRegisterDto;
import com.bunny.collagemgt.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/register")
	public String register(@RequestBody DepartmentRegisterDto request) {
		if (departmentService.registerDepartment(request)) {
			return "register " + request.getName();
		} else {
			return request.getName() + " Sorry Not register";
		}
	}

	@PostMapping("/")
	public List<Department> allDepartment() {
		return departmentService.getAllDepartment();
	}

}
