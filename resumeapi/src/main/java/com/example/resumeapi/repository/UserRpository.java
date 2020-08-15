package com.example.resumeapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.resumeapi.entity.User;

@Repository
public interface UserRpository extends CrudRepository<User, Long> {

	@Query("SELECT e from User e where e.firstName =:name ")
	List<User> findByName(@Param("name") String name);

	public User findByEmailIdAndPassword(String emailId, String password);
}
