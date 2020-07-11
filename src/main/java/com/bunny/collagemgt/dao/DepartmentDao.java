package com.bunny.collagemgt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bunny.collagemgt.model.Department;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Integer> {

}
