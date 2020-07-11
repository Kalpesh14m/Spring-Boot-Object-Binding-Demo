package com.bunny.collagemgt.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentRegisterDto {
	private String name;
	private String email;
	private String password;
	private Long mobileNumber;

}