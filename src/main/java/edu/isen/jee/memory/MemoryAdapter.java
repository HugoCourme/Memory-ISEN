package edu.isen.jee.memory;

import java.util.List;

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
			game.setScore(coreGame.getPlayersScore());
			return;
		}

		int index = 0;
		for (Card card : coreGame.getBoard()) {
			card.side = game.getListOfCard().get(index).getSide();
			card.frontColorIndex = game.getListOfCard().get(index++).getFrontColorIndex();
		}
	}

	@Override
	public void returnCard(int cellNumber) throws GameException {
		coreGame.returnCard(cellNumber);
		game.getListOfCard().get(cellNumber).setSide(coreGame.getCard(cellNumber).side);
		switchTurn();

		dao.save(game);
	}

	private void switchTurn() {
		if (!canReplay())
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
	public boolean isFinish() {
		return coreGame.isFinish();
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
		coreGame.setPlayerScore(player, score);
	}

	public String getToken() {
		return game.getToken();
	}

	public List<Card> getBoard() {
		return coreGame.getBoard();
	}

}
