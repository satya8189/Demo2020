package com.example.resumeapi.model;

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
@Table(name = "identifier")
public class Identifier {
	@Id
	@Column(name = "Identifier_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long identifierId;
}
