package com.felipehogrefe.gamesranking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipehogrefe.gamesranking.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
