package com.bunny.collagemgt.service.provider;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bunny.collagemgt.dao.TeacherDao;
import com.bunny.collagemgt.model.Teacher;
import com.bunny.collagemgt.model.dto.TeacherLoginDto;
import com.bunny.collagemgt.model.dto.TeacherRegisterDto;
import com.bunny.collagemgt.service.TeacherService;
import com.bunny.collagemgt.utils.DateUtility;

@Service
public class TeacherServiceProvider implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean registerTeacher(TeacherRegisterDto request) {
		Teacher s = modelMapper.map(request, Teacher.class);
		s.setRegistrationDate(DateUtility.todayDateTime());
		s.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		teacherDao.save(s);
		return true;
	}

	@Override
	public Optional<Teacher> login(TeacherLoginDto request) {
		Optional<Teacher> maybeTeacher = teacherDao.findByEmail(request.getEmail());
		if (maybeTeacher.isPresent()
				&& bCryptPasswordEncoder.matches(request.getPassword(), maybeTeacher.get().getPassword())) {
			return maybeTeacher;
		}
		return null;
	}

}
