package edu.isen.jee.memory.jpa;

import java.util.List;

import edu.isen.jee.memory.core.Card;
import edu.isen.jee.memory.core.MemoryGame;
import edu.isen.jee.memory.core.MemoryGameImpl;

public class MemoryAdapter implements MemoryGame {

	private Game game;

	private MemoryGame coreGame;

	private MemoryDAO dao;

	public MemoryAdapter(MemoryDAO dao, Game game) {
		this.game = game;
		this.dao = dao;
		this.coreGame = new MemoryGameImpl();

		if (game.getListOfCard().isEmpty()) {
			for (Card card : coreGame.getBoard()) {
				game.getListOfCard().add(new CardEntity(game, card.frontColorIndex, card.side));
			}
			game.setScore(getPlayersScore());
			return;
		}

		int index = 0;
		for (Card card : coreGame.getBoard()) {
			card.side = game.getListOfCard().get(index).getSide();
			card.frontColorIndex = game.getListOfCard().get(index++).getFrontColorIndex();
		}
		coreGame.setPlayerScore(0, game.getScore()[0]);
		coreGame.setPlayerScore(1, game.getScore()[1]);
	}

	@Override
	public void returnCard(int cellNumber) {
		coreGame.returnCard(cellNumber);
		game.getListOfCard().get(cellNumber).setSide(coreGame.getCard(cellNumber).side);
		game.addToCardBuffer(cellNumber);
		score(getCurrentPlayer());
		dao.save(game);
	}

	private void score(int player) {
		System.out.print("player " + player);
		setPlayerScore(player, getPlayersScore()[player] + 2);
	}

	public void returnLastCards() {
		for (int cardIndex : game.getCardBuffer()) {
			coreGame.returnCard(cardIndex);
			game.getListOfCard().get(cardIndex).setSide(coreGame.getCard(cardIndex).side);
		}
		switchTurn();
		dao.save(game);
	}

	private void switchTurn() {
		game.setCurrentPlayer(game.getCurrentPlayer() == 0 ? 1 : 0);
	}

	@Override
	public int getNumberOfCard() {
		return coreGame.getNumberOfCard();
	}

	@Override
	public Card getCard(int cellNumber) {
		return coreGame.getCard(cellNumber);
	}

	@Override
	public boolean canReplay() {
		return coreGame.canReplay();
	}

	@Override
	public boolean isFinished() {
		return coreGame.isFinished();
	}

	@Override
	public int[] getPlayersScore() {
		return coreGame.getPlayersScore();
	}

	public int getCurrentPlayer() {
		return game.getCurrentPlayer();
	}

	@Override
	public void setPlayerScore(int player, int score) {
		System.out.println(" set score : " + score);
		coreGame.setPlayerScore(player, score);
		game.setScore(getPlayersScore());
	}

	public String getToken() {
		return game.getToken();
	}

	public List<Card> getBoard() {
		return coreGame.getBoard();
	}

}
