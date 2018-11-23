package com.felipehogrefe.gamesranking;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipehogrefe.gamesranking.domain.Player;
import com.felipehogrefe.gamesranking.repositories.PlayerRepository;

@SpringBootApplication
public class GamesRankingApplication implements CommandLineRunner{
	
	@Autowired
	private PlayerRepository playerRepository;

	public static void main(String[] args) {
		SpringApplication.run(GamesRankingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Player p1 = new Player(null,"Mr. Nice",20,21);	
		Player p2 = new Player(null,"Narco",19,22);	
		Player p3 = new Player(null,"Bombasto",18,23);
		Player p4 = new Player(null,"Celeritas",17,24);	
		Player p5 = new Player(null,"Magneta",16,25);	
		Player p6 = new Player(null,"RubberMan",15,26);
		Player p7 = new Player(null,"Dynama",14,27);	
		Player p8 = new Player(null,"Dr IQ",13,28);	
		Player p9 = new Player(null,"Magma",12,29);
		Player p10 = new Player(null,"Tornado",11,30);

		playerRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));			
	}
}
