package edu.isen.jee.memory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
}
