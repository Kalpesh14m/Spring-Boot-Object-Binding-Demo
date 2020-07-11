package com.bunny.collagemgt.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bunny.collagemgt.model.dto.DepartmentRegisterDto;
import com.bunny.collagemgt.utils.DateUtility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private int id;
	private String name;
	private Long code;
	private LocalDateTime createdDateTime;

	public Department(DepartmentRegisterDto request) {
		this.name = request.getName();
		this.code = request.getCode();
		this.createdDateTime = DateUtility.todayDateTime();
	}
}