package com.example.resumeapi.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {

	private Long userId;
	private String firstName;
	private String lastName;
	private String status;
	private String email;
	private String password;
	// child

	private String mobileNumber;
	private String address;
	private String city;
	private String country;
	private String pinCode;
	private String hobbies;
	
	private List<Long> hobbiesIdList;
	
	
}
