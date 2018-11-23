package com.felipehogrefe.gamesranking;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.felipehogrefe.gamesranking.domain.Player;
import com.felipehogrefe.gamesranking.repositories.PlayerRepository;
import com.felipehogrefe.gamesranking.services.PlayerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamesRankingApplicationTests {
	private static Player p1, p2, p3, p4;
	private static boolean setUpIsDone = false;

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	PlayerService playerService;
	
	@Before
	public void setUp() {
		if(setUpIsDone) {
			return;
		}
		p1 = new Player(null,"José",30,30);
		p2 = new Player(null,"Carlos",20,25);
		p3 = new Player(null,"Camila",15,35);

		playerRepository.saveAll(Arrays.asList(p2,p1,p3));
		setUpIsDone = true;
	}
	
	@Test
	public void listPlayers() {
		List<Player> list = playerService.getPlayersList();		
		assertEquals(3,list.size());
	}
		
	@Test
	public void mustReturnAnOrdenedList() {			
		List<Player> players = playerService.getListOfPlayersOrderedByVictory();

		assertEquals(p1.getId(),players.get(0).getId());		
		assertEquals(p2.getId(),players.get(1).getId());
		assertEquals(p3.getId(),players.get(2).getId());		
	}
	
	@Test
	public void saveNewPlayer() {

		p4 = new Player(null,"Ramon",25,30);
		playerService.addPlayer(p4);
		
		Player p5 = playerService.find(p4.getId()).get();
		
		assertEquals(p4.toString(),p5.toString());	
	}
	
	@Test
	public void addMatch() {
		Integer initialMatches = p1.getMatches();
		initialMatches += 1;
		
		playerService.addMatchToPlayer(p1);
				
		assertEquals(initialMatches,playerService.find(p1.getId()).get().getMatches());
	}
	
	@Test
	public void addVictory() {
		Integer initialMatches = p1.getMatches();
		Integer initialVictories = p1.getVictories();
		initialMatches++;
		initialVictories++;
		
		playerService.addVictoryToPlayer(p1);

		assertEquals(initialMatches,playerService.find(p1.getId()).get().getMatches());
		assertEquals(initialVictories,playerService.find(p1.getId()).get().getVictories());
	}
}
