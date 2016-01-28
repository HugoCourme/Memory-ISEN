package edu.isen.jee.memory;

public class Card {
	
	public enum Side {
		RECTO, VERSO
	}

	public int frontColorIndex;
	public Side side;

	public Card(int frontColorIndex) {
		this.frontColorIndex = frontColorIndex;
		this.side = Side.VERSO;
	}
}
