package com.mysqlresttest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PLAYER", schema = "football_data_db")
public class Player {
	
	@Id
	@Column(name = "ID")
	private Integer playerId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "POSITION")
	private String position;
	
	@Temporal(TemporalType.DATE)
	@Column(name  = "DATEOFBIRTH")
	private Date dateOfBirth;
	
	@Column(name = "CONTRYOFBIRTH")
	private String countryOfBirth;
	
	@Column(name = "NATIONALITY")
	private String nationality;
}
