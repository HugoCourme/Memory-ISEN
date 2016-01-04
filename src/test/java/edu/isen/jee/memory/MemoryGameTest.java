package edu.isen.jee.memory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import edu.isen.jee.memory.Card.Side;

public class MemoryGameTest {

    private MemoryGame game;

    @Before
    public void doBefore() throws Exception {
        game = new MemoryGameImpl();
    }

    @Test
    public void twoDifferentCardReturnedDontStayThatWay() throws Exception {

    }
    
    @Test
    public void twoSameCardStayReturned() throws Exception {

    }
    
    @Test
    public void aPlayerCantReturnOnlyTwoCardInARow() throws Exception {

    }    
    
    @Test
    public void aCardCanBeReturn() throws Exception {
    	int cellNumber = RandomUtils.nextInt(game.getNumberOfCard());
    	game.returnCard(cellNumber);
    	assertThat(game.getCard(cellNumber).side).isEqualTo(Side.RECTO);
    }
}
