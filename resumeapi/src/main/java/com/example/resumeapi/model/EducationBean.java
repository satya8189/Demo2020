package com.example.resumeapi.model;

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
public class EducationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Long educationId;


	private String specilization;


	private Long marks;


	private Date yearOfPassing;

	
	private Long startYear;

	
	private Long qualificationId;


	private Long userId;
	
	private String userName;


}