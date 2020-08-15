package com.example.resumeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.resumeapi.model.EducationBean;
import com.example.resumeapi.model.UserBean;
import com.example.resumeapi.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SampleController {

	@Autowired
	private UserService userService;

	@GetMapping("/welcome")
	public String getData() {
		return "welcome to rest apis";

	}

	@PostMapping("/user")
	public @ResponseBody UserBean saveUser(@RequestBody UserBean userBean) {

		UserBean data = userService.saveUser(userBean);
		return data;

	}

	@GetMapping("/getUserList")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<UserBean> getUserList() {

		List<UserBean> list = userService.getUserList();
		return list;

	}

	@GetMapping("/getUserData/{userId}")
	public UserBean getUserData(@PathVariable Long userId) {

		return userService.getUserData(userId);
	}

	@PutMapping("/user")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public @ResponseBody UserBean updateUser(@RequestBody UserBean userBean) {

		UserBean data = userService.updateUser(userBean);
		return data;

	}

	@DeleteMapping("/user/{userId}")
	public UserBean deleteUser(@PathVariable Long userId) {

		userService.deleteUser(userId);
		UserBean userBean = new UserBean();
		userBean.setStatus("Delete successfully");
		return userBean;
	}

	@GetMapping("/getUserExt/{userId}")
	public UserBean getUserExt(@PathVariable Long userId) {

		return userService.getUserExt(userId);
	}

	@GetMapping("/getEductionList/{userId}")
	public List<EducationBean> getEductionList(@PathVariable Long userId) {
		List<EducationBean> list = userService.getEductionList(userId);
		return list;

	}
	
	@PostMapping("/userLogin")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public @ResponseBody UserBean userLogin(@RequestBody UserBean userBean) {
		UserBean data = userService.userLogin(userBean);
		return data;

	}


}
