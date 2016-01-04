package edu.isen.jee.memory;

public interface MemoryGame {
	
	/**
	 * Return a card
	 * */
    void returnCard(int cellNumber) throws GameException;
}
