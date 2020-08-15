package com.example.resumeapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.resumeapi.entity.UserExt;

@Repository
public interface UserExtRpository extends CrudRepository<UserExt,Long>{

}
