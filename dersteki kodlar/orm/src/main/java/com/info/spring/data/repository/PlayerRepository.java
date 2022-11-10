package com.info.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.info.spring.data.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {
	
	@Query("SELECT p FROM Player p WHERE p.team.teamId = :teamId")
	List<Player> findAllByTeamId(@Param("teamId") long teamId);
}
