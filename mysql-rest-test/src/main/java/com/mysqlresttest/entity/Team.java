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
@Table(name = "TEAM", schema = "football_data_db")
public class Team {

	@Id
	@Column(name = "ID")
	private Integer teamId;
	
	@Column(name = "NAME")
	private String teamName;
	
	@Column(name = "TLA")
	private String tla;
	
	@Column(name = "SHORTNAME")
	private String teamShortName;
	
	@Column(name = "EMAIL")
	private String teamEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "area_name", referencedColumnName = "ID")
	private Area area;
	
	@OneToMany
	@JoinColumn(name = "playersInTeam")
	private Set<Player> squad;
}
