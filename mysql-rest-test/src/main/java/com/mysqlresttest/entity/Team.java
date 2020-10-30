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
@Table(name = "TEAM", schema = "football_data_db")
public class Team {

	@Id
	@Column(name = "ID")
	@SerializedName("id")
	private Integer teamId;
	
	@Column(name = "NAME")
	@SerializedName("name")
	private String teamName;
	
	@Column(name = "TLA")
	@SerializedName("tla")
	private String tla;
	
	@Column(name = "SHORTNAME")
	@SerializedName("shortName")
	private String teamShortName;
	
	@Column(name = "EMAIL")
	@SerializedName("email")
	private String teamEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "area_name", referencedColumnName = "ID")
	private Area area;
	
	@OneToMany
	@JoinColumn(name = "playersInTeam")
	private Set<Player> squad;
}
