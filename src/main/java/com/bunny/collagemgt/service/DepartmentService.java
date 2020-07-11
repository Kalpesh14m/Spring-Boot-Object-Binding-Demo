package com.bunny.collagemgt.service;

import java.util.List;

import com.bunny.collagemgt.model.Department;
import com.bunny.collagemgt.model.dto.DepartmentRegisterDto;

public interface DepartmentService {

	public boolean registerDepartment(DepartmentRegisterDto request);

	public List<Department> getAllDepartment();

}
