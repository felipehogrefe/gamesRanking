package com.felipehogrefe.gamesranking.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipehogrefe.gamesranking.domain.Player;
import com.felipehogrefe.gamesranking.services.PlayerService;


@RestController
@RequestMapping(value="/player")
public class PlayerResource {
	@Autowired
	private PlayerService playerService;
	
	@CrossOrigin
	@PutMapping(value="/increaseMatches/{id}")
	public ResponseEntity<?> increaseMatches(@PathVariable Integer id) {	
		Optional<Player> player = playerService.find(id);
		if(player.isPresent()){
			playerService.addMatchToPlayer(player.get());
			return ResponseEntity.ok(HttpStatus.OK);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PutMapping(value="/increaseVictories/{id}")
	public ResponseEntity<?> increaseVictories(@PathVariable Integer id) {	
		Optional<Player> player = playerService.find(id);
		if(player.isPresent()){
			playerService.addVictoryToPlayer(player.get());
			return ResponseEntity.ok(HttpStatus.OK);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@CrossOrigin
	@GetMapping(value="/orderedList")
	public List<Player> increaseVictories() {	
		return playerService.getListOfPlayersOrderedByVictory();		
	}
	
	@CrossOrigin
	@PostMapping(value="/new")
	public ResponseEntity<?> newPlayer(@RequestBody Player player){
		playerService.addPlayer(player);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
	
}
