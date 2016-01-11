package edu.isen.jee.memory;


public class MemoryAdapter implements MemoryGame{
	
	private Game game;
	
	private MemoryGame coreGame;
	
	private MemoryDAO dao;
	
	public MemoryAdapter(MemoryDAO dao, Game game){
		this.game = game;
		this.dao = dao;
		this.coreGame = new MemoryGameImpl();
	}

	@Override
	public void returnCard(int cellNumber) throws GameException {
		coreGame.returnCard(cellNumber);
		switchTurn();
		
		dao.save(game);
	}
	
	private void switchTurn(){
		if (!coreGame.canReplay())
			game.setCurrentPlayer(game.getCurrentPlayer()==0?1:0);
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

	@Override
	public void setPlayerScore(int player, int score) {
		coreGame.setPlayerScore(player, score);
	}

}
