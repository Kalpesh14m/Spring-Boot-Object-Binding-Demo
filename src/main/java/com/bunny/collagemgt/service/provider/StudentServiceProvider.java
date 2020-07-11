package com.bunny.collagemgt.service.provider;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bunny.collagemgt.dao.StudentDao;
import com.bunny.collagemgt.model.Student;
import com.bunny.collagemgt.model.dto.StudentLoginDto;
import com.bunny.collagemgt.model.dto.StudentRegisterDto;
import com.bunny.collagemgt.service.StudentService;
import com.bunny.collagemgt.utils.DateUtility;

@Service
public class StudentServiceProvider implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean registerStudent(StudentRegisterDto request) {
		Student s = new Student();
		s.setRegistrationDate(DateUtility.todayDateTime());
		request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		BeanUtils.copyProperties(request, s);
		studentDao.save(s);
		return true;
	}

	@Override
	public Optional<Student> login(StudentLoginDto request) {
		Optional<Student> maybeStudent = studentDao.findByEmail(request.getEmail());
		if (maybeStudent.isPresent()
				&& bCryptPasswordEncoder.matches(request.getPassword(), maybeStudent.get().getPassword())) {
			return maybeStudent;
		}
		return null;
	}
}
