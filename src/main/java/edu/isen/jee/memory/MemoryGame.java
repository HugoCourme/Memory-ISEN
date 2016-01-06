package edu.isen.jee.memory;


public interface MemoryGame {	
	/**
	 * Return a card
	 * */
    void returnCard(int cellNumber) throws GameException;
    
    int getNumberOfCard();
    
    Card getCard(int cellNumber);
    
    int[] getPlayersScore();
    
    void setPlayerScore(int player, int score);
    
    boolean canReplay();
    
    boolean isFinish();
}
