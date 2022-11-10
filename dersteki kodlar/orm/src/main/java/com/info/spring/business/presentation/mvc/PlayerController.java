package com.info.spring.business.presentation.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.spring.configuration.MyBean;
import com.info.spring.data.entity.Player;
import com.info.spring.data.repository.PlayerRepository;

@Controller
@RequestMapping("/sports")
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private MyBean myBean;
	
	@GetMapping("/players/byteam")
	@ResponseBody
	public String getPlayersByTeam() {
		System.out.println("Çekirdek: " + myBean.getMyLong() + " "
				+ myBean.getMyString() + " " + myBean.getMyDouble());
		long teamId = 2;
		List<Player> players = playerRepository.findAllByTeamId(teamId);
		double totalScore = 0;
		
		for(Player player: players) {
			System.out.println(player.getPlayerId() + " - " + player.getPlayerName() + " - " + player.getAverageScore());
			totalScore += player.getAverageScore();
		}
		
		double averageScore = 0;
		
		if(players.size() > 0) {
			averageScore = totalScore / players.size();
		}
		
		return "Ortalama çentik: " + averageScore; //productRepository.count();
	}
}
