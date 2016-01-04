package edu.isen.jee.memory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import org.junit.Before;
import org.junit.Test;

public class MemoryGameTest {

    private MemoryGame game;

    @Before
    public void doBefore() throws Exception {
        game = new MemoryGameImpl();
    }

    @Test
    public void aPlayerMayReturnACard() throws Exception {
    	
    }

    @Test
    public void twoDifferentCardAreReturned() throws Exception {

    }
    
    @Test
    public void twoSameCardArentReturned() throws Exception {

    }
    
    @Test
    public void aPlayerCantReturnOnlyTwoCardInARow() throws Exception {

    }
}
