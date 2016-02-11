package edu.isen.jee.memory.web;

import edu.isen.jee.memory.core.Card;
import edu.isen.jee.memory.core.Card.Side;

public class CardColorWrapper {

	private Card card;
	private int index;
	public CardColorWrapper(int index, Card card){
		this.card = card;
		this.index = index;
	}
	
	public int getIndex(){
		return index;
	}
	
	public String getCssColor(){
		if(card.side==Side.VERSO){
			return null;
		}
		switch(card.frontColorIndex){
		case 0: return "green";
		case 1: return "yellow";
		case 2: return "red";
		case 3: return "orange";
		case 4: return "purple";
		case 5: return "blue";
		case 6: return "teal";
		case 7: return "pink";
		}
		return null;
	}
}
