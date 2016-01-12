package edu.isen.jee.memory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String token;

	private List<Card> board = new ArrayList<>();

	private int currentPlayer = 0;

	public Game() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Card> getListOfCard() {
		return board;
	}

	public void setListOfCard(List<Card> board) {
		this.board = board;
	}

	public void setCurrentPlayer(int player) {
		this.currentPlayer = player;
	}

	public int getCurrentPlayer() {
		return this.currentPlayer;
	}

}
