package com.mysqlresttest.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COMPETITION", schema = "football_data_db")
public class Competition {
 
	@Id
	@Column(name = "ID")
	private Integer competitionId;
	
	@Column(name = "CODE")
	private Integer competitionCode;
	
	@Column(name = "NAME")
	private String competitionName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "area_name", referencedColumnName = "ID")
	private Area area;
	
	@OneToMany
	@JoinColumn(name = "teamsInCompetition")
	private Set<Team> teamsInCompetition;
}
