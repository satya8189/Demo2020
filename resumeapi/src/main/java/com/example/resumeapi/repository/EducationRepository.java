package com.example.resumeapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.resumeapi.entity.Education;

@Repository
public interface EducationRepository extends CrudRepository<Education,Long>{
	
	public List<Education> findByUserId(Long userId);
	
	
	
	@Query("SELECT u FROM Education u WHERE u.userId =:userId ")
	public List<Education> getEducationData(Long userId);
	
	
	@Query( value="SELECT * FROM education u WHERE u.User_Id =:userId" , nativeQuery = true)
	public List<Education> getEducationDataWihSql(Long userId);

}
