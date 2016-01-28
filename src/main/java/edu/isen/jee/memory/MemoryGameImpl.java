package edu.isen.jee.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import edu.isen.jee.memory.Card.Side;

public class MemoryGameImpl implements MemoryGame {

	private static final int CARD_NUMBER = 16;
	public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";

	private int[] playersScore = { 0, 0 };

	private List<Card> board = new ArrayList<>(CARD_NUMBER);

	public MemoryGameImpl() {
		initBoard();
	}

	private void initBoard() {
		for (int i = 0; i < CARD_NUMBER; i++) {
			board.add(new Card((int) (i / 2)));
		}
		Collections.shuffle(board);
	}

	@Override
	public void returnCard(int cellNumber) throws GameException {
		if (cellNumber > CARD_NUMBER) {
			throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		}
		Card currentCard = getCard(cellNumber); 
		Side currentSide = currentCard.side;
		currentCard.side = (currentSide == Side.RECTO) ? Side.VERSO : Side.RECTO;
	}

	@Override
	public boolean canReplay() {
		if(board.stream().filter(card ->card.side==Side.RECTO).count()%2!=0){
			return true;
		}
		 return board.stream().filter(card -> card.side==Side.RECTO)
				 .allMatch(card->(board.stream().filter(c-> c.side==Side.RECTO).filter(c->c.frontColorIndex==card.frontColorIndex).count()==2));
	}

	@Override
	public boolean isFinish() {
		 return board.stream().filter(card -> card.side==Side.RECTO).count()==CARD_NUMBER;
	}

	@Override
	public Card getCard(int cellNumber) {
		return board.get(cellNumber);
	}

	@Override
	public int getNumberOfCard() {
		return CARD_NUMBER;
	}

	@Override
	public int[] getPlayersScore() {
		return playersScore;
	}

	@Override
	public void setPlayerScore(int player, int score) {
		this.playersScore[player] = score;
		System.out.println("score : ["+playersScore[0]+","+playersScore[0]+"]");
	}

	@Override
	public List<Card> getBoard() {
		return board;
	}
}
