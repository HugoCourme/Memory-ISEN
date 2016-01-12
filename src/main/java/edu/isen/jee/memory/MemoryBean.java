package edu.isen.jee.memory;

import java.io.Serializable;
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

	/*
	 * public MemoryBean() { System.out.println("MemoryBean creation");
	 * if(dao==null){ System.out.println("dao == null"); dao = new MemoryDAO();
	 * } }
	 */

	public List<Card> getCards() {
		return game.getBoard();
	}

	public void play(int cellNumber) {
		game.returnCard(cellNumber);
	}

	public int getPlayersScore() {
		return 10;
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

	public void loadFromToken(String token) {
		game = dao.loadFromToken(token);
	}
}
