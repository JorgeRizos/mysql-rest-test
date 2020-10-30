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

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COMPETITION", schema = "football_data_db")
public class Competition {
 
	@Id
	@Column(name = "ID")
	@SerializedName("id")
	private Integer competitionId;
	
	@Column(name = "CODE")
	@SerializedName("code")
	private String competitionCode;
	
	@Column(name = "NAME")
	@SerializedName("name")
	private String competitionName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "area_name", referencedColumnName = "ID")
	private Area area;
	
	@OneToMany
	@JoinColumn(name = "teamsInCompetition")
	private Set<Team> teamsInCompetition;
}
