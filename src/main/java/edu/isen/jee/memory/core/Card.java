package edu.isen.jee.memory.core;

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
