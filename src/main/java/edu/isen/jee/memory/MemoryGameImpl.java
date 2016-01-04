package edu.isen.jee.memory;

import java.util.ArrayList;
import java.util.List;

public class MemoryGameImpl implements MemoryGame {
	
	private static final int CARD_NUMBER= 10;
    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";
    
	List<CardColour> board = new ArrayList<>(CARD_NUMBER);
	
	public MemoryGameImpl() {
	}

    private void initBoard() {
        for (int i = 0; i < CARD_NUMBER; i++) {
        	//do something
        }
    }
	
	@Override
	public void returnCard(int cellNumber) throws GameException {
		if(cellNumber>CARD_NUMBER){
			throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		}
	}
}
