
package edu.isen.jee.memory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public enum Side {
		RECTO, VERSO
	}

	@ManyToOne
	Game game;
	
	@Column(name="frontColorIndex")
	private int frontColorIndex;
	
	@Column(name="side")
	private Side side;
	
	@Column(name="index")
	private int index;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public CardEntity() {
		
	}

	public CardEntity(Game game, int frontColorIndex) {
		this.game = game;
		this.frontColorIndex = frontColorIndex;
		this.side = Side.VERSO;
	}

	public int getFrontColorIndex() {
		return frontColorIndex;
	}

	public void setFrontColorIndex(int frontColorIndex) {
		this.frontColorIndex = frontColorIndex;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}
	
}
