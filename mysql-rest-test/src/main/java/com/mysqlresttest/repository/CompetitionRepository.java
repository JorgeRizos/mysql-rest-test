package com.mysqlresttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mysqlresttest.entity.Competition;

@RepositoryRestResource(path = "competition")
public interface CompetitionRepository extends JpaRepository<Competition, Integer>{

}
