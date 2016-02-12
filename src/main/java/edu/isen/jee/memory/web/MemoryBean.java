package edu.isen.jee.memory.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.isen.jee.memory.core.Card;
import edu.isen.jee.memory.core.MemoryGame;
import edu.isen.jee.memory.jpa.MemoryAdapter;
import edu.isen.jee.memory.jpa.MemoryDAO;

@Named("game")
@RequestScoped
public class MemoryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	MemoryAdapter game;

	@Inject
	MemoryDAO dao;

	public List<CardColorWrapper> getCards() {
		List<CardColorWrapper> board = new ArrayList<>();
		int index = 0;
		for (Card card : game.getBoard()) {
			board.add(new CardColorWrapper(index++, card));
		}
		return board;
	}

	public void play(int cellNumber) {
		game.returnCard(cellNumber);
	}

	public void returnLastCards() {
		game.returnLastCards();
	}

	public boolean getIfReplay() {
		return game.canReplay();
	}

	public int[] getPlayersScore() {
		return game.getPlayersScore();
	}

	public String getToken() {
		return game.getToken();
	}

	public MemoryGame getGame() {
		return game;
	}

	public void createNewGame() {
		game = dao.createNewGame();
	}

	public int getCurrentPlayer() {
		return game.getCurrentPlayer();
	}

	public void loadFromToken(String token) {
		game = dao.loadFromToken(token);
	}
	
	public boolean getIsFinished(){
		return game.isFinished();
	}
}
