package com.felipehogrefe.gamesranking.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player implements Serializable, Comparable<Player>{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private Integer victories;
	private Integer matches;
	
	public Player() {}
	
	public Player (Integer _id, String _name, Integer _victories, Integer _matches) {
		super();
		id = _id;
		name = _name;
		victories = _victories;
		matches = _matches;
	}
	
	public void increaseMatches() {
		matches++;
	}
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", victories=" + victories + ", matches=" + matches + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getVictories() {
		return victories;
	}
	public void setVictories(Integer victories) {
		this.victories = victories;
	}
	public Integer getMatches() {
		return matches;
	}
	public void setMatches(Integer matches) {
		this.matches = matches;
	}
	public Integer getId() {
		return id;
	}	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public int compareTo(Player p) {
		if(victories<p.victories) return 1;
		if(victories>p.victories) return -1;
		return 0;
	}

	public void increaseVictories() {
		matches++;
		victories++;
	}
}