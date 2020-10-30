package com.mysqlresttest.dto;

import java.util.Set;

import com.mysqlresttest.entity.Competition;
import com.mysqlresttest.entity.Team;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {

	private Competition competition;
	private Set<Team> teams;
}
