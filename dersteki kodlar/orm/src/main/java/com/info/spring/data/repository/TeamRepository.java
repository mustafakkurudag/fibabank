package com.info.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.info.spring.data.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
	

}
