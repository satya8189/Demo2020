package com.example.resumeapi.entity;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "education")
public class Education implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Education_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long educationId;

	@Column(name = "Specilization")
	private String specilization;

	@Column(name = "Marks")
	private Long marks;


	@Column(name = "Start_Year")
	private Long startYear;

	@Column(name = "Qualification_Id")
	private Long qualificationId;
	

	   

	@Column(name = "User_Id")
	private Long userId;

	@JoinColumn(name = "User_Id", insertable = false, updatable = false)
	@ManyToOne
	private User user;
	


	
}