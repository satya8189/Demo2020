package com.example.resumeapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.resumeapi.entity.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_hobbies")
public class UserHobbies {
	
	@Id
	@Column(name = "User_HobbId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userHobbId;
	
	@Column(name = "User_Id")
	private Long userId;
	
	@Column(name = "Identifier_Id")
	private Long identifierId;
	
	

	@JoinColumn(name = "User_Id", insertable = false, updatable = false)
	@ManyToOne
	private User user;
	
	@JoinColumn(name = "Identifier_Id", insertable = false, updatable = false)
	@ManyToOne
	private Identifier identifier;
}
