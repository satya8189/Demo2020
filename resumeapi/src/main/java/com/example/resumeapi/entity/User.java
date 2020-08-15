package com.example.resumeapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "users")
public class User implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Id")
    private Long userId;

    @Column(name = "FirstName")
    private String firstName;
    
    @Column(name = "LastName")
    private String lastName;     
    
    @Column(name = "EmailId")
    private String emailId;
    
    @Column(name = "Password")
    private String password;
    
    @Column(name = "Status")
    private String status;
    
}
