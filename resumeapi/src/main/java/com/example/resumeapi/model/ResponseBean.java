package com.example.resumeapi.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ResponseBean {
	private List<UserBean>  userList;
	private UserBean userBean;

	
}
