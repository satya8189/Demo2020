package com.example.resumeapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.resumeapi.entity.Education;
import com.example.resumeapi.entity.User;
import com.example.resumeapi.entity.UserExt;
import com.example.resumeapi.model.EducationBean;
import com.example.resumeapi.model.UserBean;
import com.example.resumeapi.model.UserHobbies;
import com.example.resumeapi.repository.CustomRepository;
import com.example.resumeapi.repository.EducationRepository;
import com.example.resumeapi.repository.UserExtRpository;
import com.example.resumeapi.repository.UserRpository;

@Service
public class UserService {
	
	@Autowired
	UserRpository userRpository;
	
	@Autowired
	UserExtRpository userExtRpository;
	@Autowired
	EducationRepository educationRepository;
	
	@Autowired
	CustomRepository customRepository;
	
	public UserBean saveUser(UserBean userBean) {
		System.out.println("name--"+userBean.getFirstName());
		
		User user=new User();
	
		if(userBean.getUserId()!=null) {
			user.setUserId(userBean.getUserId());
		}
		user.setFirstName(userBean.getFirstName());
		user.setLastName(userBean.getLastName());
		user.setPassword(userBean.getPassword());
		user.setEmailId(userBean.getEmail());
		userRpository.save(user);
		
		UserExt userExt=new UserExt();
		userExt.setUserId(user.getUserId());
		userExt.setCity(userBean.getCity());
		userExt.setCountry(userBean.getCountry());
		userExt.setHobbies(userBean.getHobbies());
		userExt.setMobileNumber(userBean.getMobileNumber());
		userExt.setPinCode(userBean.getPinCode());
		userExtRpository.save(userExt);
		for(Long hId:userBean.getHobbiesIdList()) {
			UserHobbies uh=new UserHobbies();
			uh.setUserId(user.getUserId());
			uh.setIdentifierId(hId);
			//userExtRpository.save(uh);
		}
		
		
		
		userBean.setUserId(user.getUserId());
		
		return userBean;
		
	}
	public UserBean updateUser(UserBean userBean) {
		User  userObj=userRpository.findById(userBean.getUserId()).orElse(null);
		
		userObj.setFirstName(userBean.getFirstName());
		userObj.setLastName(userBean.getLastName());
		
		userRpository.save(userObj);
		return userBean;
	}
	
	
	
	public List<UserBean> getUserList() {
		List<UserBean> list=new ArrayList<>();
		
	List<User> usersList=(List<User>) userRpository.findAll();
	/*List<UserBean> data= usersList.stream().map(u-> new UserBean(u.getUserId(),
			                    u.getFirstName(),
			                    u.getLastName(),
			                    u.getStatus(),
			                    u.getEmailId(),
			                    u.getPassword()
			                    )).collect(Collectors.toList());*/
	
	
	
	  for(User userObj:usersList) {
		  
		  UserBean userBean=new UserBean();
		  userBean.setFirstName(userObj.getFirstName());
		  userBean.setLastName(userObj.getLastName());
		  userBean.setPassword(userObj.getPassword());
		  userBean.setStatus(userObj.getStatus());
		  userBean.setUserId(userObj.getUserId());
		  userBean.setEmail(userObj.getEmailId());
		  
		  
		  
		  list.add(userBean);
		  
	  }
	
 
	return list;
	
	}




	public UserBean getUserData(Long userId) {
		UserBean userBean=new UserBean();
		
		User  userObj=userRpository.findById(userId).orElse(null);
		
		if(userObj!=null) {
		userBean.setUserId(userObj.getUserId());
		 userBean.setFirstName(userObj.getFirstName());
		  userBean.setLastName(userObj.getLastName());
		  userBean.setPassword(userObj.getPassword());
		  userBean.setStatus(userObj.getStatus());
		}
		return userBean;
	}




	public void deleteUser(Long userId) {
		userRpository.deleteById(userId);
		
	}




	public UserBean getUserExt(Long userId) {
		
		UserExt userExt= userExtRpository.findById(userId).orElse(new UserExt());
		
         UserBean userBean=new UserBean();
		
		
		
		if(userExt!=null) {
			
		userBean.setUserId(userExt.getUserId());
		 userBean.setFirstName(userExt.getUser().getFirstName());
		  userBean.setLastName(userExt.getUser().getLastName());
		  userBean.setPassword(userExt.getUser().getPassword());
		  userBean.setStatus(userExt.getUser().getStatus());
		  
		  userBean.setCity(userExt.getCity());
		  userBean.setCountry(userExt.getCountry());
		  userBean.setMobileNumber(userExt.getMobileNumber());
		  userBean.setHobbies(userExt.getHobbies());
		  userBean.setPinCode(userExt.getPinCode());
		  
		}
		return userBean;
	}


	
	public void saveEducation(EducationBean educationBean) {
		Education education=new Education();
		education.setMarks(educationBean.getMarks());
		education.setSpecilization(educationBean.getSpecilization());
		education.setStartYear(educationBean.getStartYear());
		
		education.setQualificationId(educationBean.getQualificationId());
		education.setUserId(educationBean.getUserId());
		educationRepository.save(education);
		
	}


	public List<EducationBean> getEductionList(Long userId) {
		// 
		List<Education> educationList=educationRepository.findByUserId(userId);
		
		//hql query
		//List<Education> educationList=educationRepository.getEducationData(userId);
		
		//native sql query
		//List<Education> educationList=educationRepository.getEducationDataWihSql(userId);
		
		
		 //custom repository with hql
		//List<Education> educationList=customRepository.getEducationlistHql(userId);
		
		
	   //custom repository with sql
		//List<Education> educationList=customRepository.getEducationByCriteria(userId);
		
		
		List<EducationBean> eductionBeanList=new ArrayList<>();
		
		for(Education  education:educationList ) {
			EducationBean educationBean=new EducationBean();
			educationBean.setEducationId(education.getEducationId());
			educationBean.setMarks(education.getMarks());
		//	educationBean.setStartYear(education.getStartYear());
			educationBean.setSpecilization(education.getSpecilization());
			educationBean.setUserId(education.getUserId());
			//if(education.getUser()!==)
			String userName=education.getUser().getFirstName()+" "+education.getUser().getLastName();
			educationBean.setUserName(userName);
			
			eductionBeanList.add(educationBean);
		}

		return eductionBeanList;
		
		
		
	}




	public UserBean userLogin(UserBean ub) {
		// TODO Auto-generated method stub
		User userObj=userRpository.findByEmailIdAndPassword(ub.getEmail(),ub.getPassword());
		  UserBean userBean=new UserBean();
			
		  if(userObj!=null) {
				userBean.setUserId(userObj.getUserId());
				 userBean.setFirstName(userObj.getFirstName());
				  userBean.setLastName(userObj.getLastName());
				  userBean.setPassword(userObj.getPassword());
				  userBean.setStatus(userObj.getStatus());
				  userBean.setEmail(userObj.getEmailId());
				}
				
			return userBean;
	
	}


}
