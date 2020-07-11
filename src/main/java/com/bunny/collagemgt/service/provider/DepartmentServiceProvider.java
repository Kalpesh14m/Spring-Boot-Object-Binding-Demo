package com.bunny.collagemgt.service.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bunny.collagemgt.dao.DepartmentDao;
import com.bunny.collagemgt.model.Department;
import com.bunny.collagemgt.model.dto.DepartmentRegisterDto;
import com.bunny.collagemgt.service.DepartmentService;

@Service
public class DepartmentServiceProvider implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public boolean registerDepartment(DepartmentRegisterDto request) {
		departmentDao.save(new Department(request));
		return true;
	}

	@Override
	public List<Department> getAllDepartment() {
		return (List<Department>) departmentDao.findAll();
	}

}
