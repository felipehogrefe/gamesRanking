package com.felipehogrefe.gamesranking.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.felipehogrefe.gamesranking.domain.Player;
import com.felipehogrefe.gamesranking.repositories.PlayerRepository;


@Service
public class PlayerService {
	@Autowired
	private PlayerRepository playerRepository;
	
	public Optional<Player> find(Integer id) {
		Optional<Player> obj = playerRepository.findById(id);
		return obj;
	}
	
	public List<Player> getPlayersList(){		
		return playerRepository.findAll(); 		
	}
	
	public List<Player> getListOfPlayersOrderedByVictory(){		
		List<Player> list = playerRepository.findAll();
		Collections.sort(list);
		return list; 		
	}
	
	public boolean addPlayer(Player p) {
		return changePlayer(p);
	}
	
	public boolean addMatchToPlayer(Player p) {	
		p.increaseMatches();
		return changePlayer(p);
	}
	public boolean addVictoryToPlayer(Player p) {	
		p.increaseVictories();
		return changePlayer(p);
	}
	
	private boolean changePlayer(Player p) {
		if(playerRepository.save(p)!=null) return true;
		return false;
	}
}
