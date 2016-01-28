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
    public void aPlayerCanScore() throws Exception {
    	int player= RandomUtils.nextInt(2);
    	assertThat(game.getPlayersScore()[player]).isEqualTo(0);
    	assertThat(game.getPlayersScore()[player==0?1:0]).isEqualTo(0);

    	int score = RandomUtils.nextInt(20);
    	game.setPlayerScore(player, score);
    	assertThat(game.getPlayersScore()[player]).isEqualTo(score);
    	assertThat(game.getPlayersScore()[player==0?1:0]).isEqualTo(0);
    }
    
    @Test
    public void theGameCanBeFinish() throws Exception {
    	for (int i = 0; i < game.getNumberOfCard(); i++) {
        	assertThat(game.isFinish()).isEqualTo(false);
			game.returnCard(i);
		}
    	assertThat(game.isFinish()).isEqualTo(true);
    }
    
    @Test
    public void itCanReplay() throws Exception {
    	int cardNumber = RandomUtils.nextInt(game.getNumberOfCard());
    	game.returnCard(cardNumber);
    	assertThat(game.canReplay()).isEqualTo(true);
    	
    	for (int i = 0; i < game.getNumberOfCard(); i++) {
			if(i==cardNumber){
				continue;
			}
			if(game.getCard(cardNumber).frontColorIndex==game.getCard(i).frontColorIndex){
				game.returnCard(i);
			}
		}
    	assertThat(game.canReplay()).isEqualTo(true);
    }
    
    @Test
    public void itCantReplayIfTwoCardAreDifferent() throws Exception {
    	int cardNumber = RandomUtils.nextInt(game.getNumberOfCard());
    	game.returnCard(cardNumber);
    	assertThat(game.canReplay()).isEqualTo(true);
    	
    	for (int i = 0; i < game.getNumberOfCard(); i++) {
			if(i==cardNumber){
				continue;
			}
			if(game.getCard(cardNumber).frontColorIndex!=game.getCard(i).frontColorIndex){
				game.returnCard(i);
				break;
			}
		}
    	assertThat(game.canReplay()).isEqualTo(false);
    }
    
    @Test
    public void aCardCanBeReturn() throws Exception {
    	int cellNumber = RandomUtils.nextInt(game.getNumberOfCard());
    	game.returnCard(cellNumber);
    	assertThat(game.getCard(cellNumber).side).isEqualTo(Side.RECTO);
    	game.returnCard(cellNumber);
    	assertThat(game.getCard(cellNumber).side).isEqualTo(Side.VERSO);
    }
}