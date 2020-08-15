package com.example.resumeapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "users_ext")
public class UserExt implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "User_Id")
    private Long userId;

    @Column(name = "MobileNumber")
    private String mobileNumber;
    
    @Column(name = "Address")
    private String address;     
    
    @Column(name = "City")
    private String city;
    
    @Column(name = "Country")
    private String country;
    
    @Column(name = "PinCode")
    private String pinCode;
    
    @Column(name = "Hobbies")
    private String hobbies;
    
    @JoinColumn(name = "User_Id", insertable = false, updatable = false)
    @OneToOne
    private User user;
}
