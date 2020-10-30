package com.mysqlresttest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "AREA", schema = "football_data_db")
public class Area {

	@Id
	@Column(name = "ID")
	private Integer areaId;
	
	@Column(name = "NAME")
	private String areaName;
	
	@OneToOne(mappedBy = "area")
	private Competition competition;
	
	@OneToOne(mappedBy = "area")
	private Team team;
}
