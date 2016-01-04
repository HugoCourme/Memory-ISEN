package edu.isen.jee.memory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


import edu.isen.jee.memory.Card.CardColor;
import edu.isen.jee.memory.Card.Side;


public class MemoryGameImpl implements MemoryGame {
	
	private static final int CARD_NUMBER= 10;
    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";
    
	List<Card> board = new ArrayList<>(CARD_NUMBER);
	
	public MemoryGameImpl() {
		initBoard();
	}

    private void initBoard() {
    	List<CardColor> cardColorList = new ArrayList<>(Arrays.asList(CardColor.values()));
    	for (int i = 0; i < CARD_NUMBER; i++) {
			board.add(new Card(cardColorList.get((int)(i/2))));
		}
		Collections.shuffle(board);
    }
	
	@Override
	public void returnCard(int cellNumber) throws GameException {
		if(cellNumber>CARD_NUMBER){
			throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		}
		board.get(cellNumber).side=Side.RECTO;
	}

	@Override
	public boolean canReplay() {
		Stream<Card> stream = board.stream().filter(card -> card.side==Side.RECTO);
		return stream.allMatch(card->(stream.filter(c->c.frontColor==card.frontColor).count()==2)?true:false)?true:false;
		
		/*
		return board.stream().filter(card -> card.side==Side.RECTO).allMatch(card->
			(board.stream().filter(c-> c.side==Side.RECTO).filter(c->c.frontColor==card.frontColor).count()==2)?true:false)?true:false;
		 */
	}
	@Override
	public boolean isFinish(){
		return board.stream().filter(card -> card.side==Side.RECTO).count()==CARD_NUMBER?true:false;
		
	}

	@Override
	public Card getCard(int cellNumber) {
		return board.get(cellNumber);
	}

	@Override
	public int getNumberOfCard() {
		return CARD_NUMBER;
	}
}
