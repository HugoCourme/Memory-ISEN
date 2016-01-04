package edu.isen.jee.memory;

public class Card {
	
	public enum CardColor {
		BLACK,RED,YELLOW,BLUE,GREEN
	}
	
	public enum Side {
		RECTO,VERSO
	}
	
	public CardColor frontColor;
	public Side side;
	
	public Card(CardColor frontColor){
		this.frontColor = frontColor;
		this.side = Side.VERSO;
	}
}
