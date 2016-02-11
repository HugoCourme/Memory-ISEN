
package edu.isen.jee.memory.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import edu.isen.jee.memory.core.Card.Side;

@Entity
public class CardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	Game game;
	
	@Column(name="frontColorIndex")
	private int frontColorIndex;
	
	@Column(name="Side")
	private Side side;

	public CardEntity() {
	}

	public CardEntity(Game game, int frontColorIndex, Side side) {
		this.game = game;
		this.frontColorIndex = frontColorIndex;
		this.side = side;
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
