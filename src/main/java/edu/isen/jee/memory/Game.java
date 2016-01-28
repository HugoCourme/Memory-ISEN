package edu.isen.jee.memory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity(name = "Game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String token;

	@OneToMany(mappedBy="game", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@OrderColumn(name="index")
	private List<CardEntity> board = new ArrayList<>();

	private int currentPlayer = 0;
	
	private int[] score = { 0, 0 };

	public Game() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<CardEntity> getListOfCard() {
		return board;
	}

	public void setListOfCard(List<CardEntity> board) {
		this.board = board;
	}

	public void setCurrentPlayer(int player) {
		this.currentPlayer = player;
	}

	public int getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	public void setScore(int[] score){
		this.score = score;
	}
	
	public int[] getScore(){
		return score;
	}

}
