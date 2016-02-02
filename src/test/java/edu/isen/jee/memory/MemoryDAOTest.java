package edu.isen.jee.memory;

import static org.assertj.core.api.Assertions.assertThat;

import edu.isen.jee.memory.guice.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GuiceRunner.class)
@Modules({ H2DBModule.class, JPAModule.class })
public class MemoryDAOTest {
	
	 @Inject
	 EntityManager em;

	 @Inject
	 MemoryDAO dao;

	 @Test
	 public void daoIsInjected() throws Exception {
	     assertThat(dao).isNotNull();
	 }
	    
	 @Test
	 public void itCanCreateAGame() throws Exception {
		 MemoryAdapter game = dao.createNewGame();
	     assertThat(game).isNotNull();

	     String token = game.getToken();
	     assertThat(game.getToken()).isNotNull();
	     em.clear();
	     game = dao.loadFromToken(token);
	     assertThat(game).isNotNull();

	 }
	 
	 @Test
	 public void itCanPlayWithJPAGame() throws Exception {
		 MemoryAdapter game = dao.createNewGame();
		 game.returnCard(0);
		 if (game.getCard(0).frontColorIndex != game.getCard(1).frontColorIndex) {
			 game.returnCard(1);
			 assertThat(game.getCard(0).side).isEqualTo(Card.Side.RECTO);
			 assertThat(game.getCard(1).side).isEqualTo(Card.Side.RECTO);
		}else {
			game.returnCard(2);
			 assertThat(game.getCard(0).side).isEqualTo(Card.Side.RECTO);
			 assertThat(game.getCard(2).side).isEqualTo(Card.Side.RECTO);
		}
		 
	 }
	 
	 @Test
	    public void adapterManagesTurns() throws Exception {
	        MemoryAdapter game = dao.createNewGame();
	        assertThat(game.getCurrentPlayer()).isNotNull();
	        assertThat(game.getCurrentPlayer()).isEqualTo(0);
	        game.returnCard(0);
			 if (game.getCard(0).frontColorIndex != game.getCard(1).frontColorIndex) {
				 game.returnCard(1);
			}else {
				game.returnCard(2);
			}
			game.returnCard(3);
	        game = dao.loadFromToken(game.getToken());
	        assertThat(game.getCurrentPlayer()).isEqualTo(1);
	        game.returnCard(0);
			 if (game.getCard(0).frontColorIndex != game.getCard(1).frontColorIndex) {
				 game.returnCard(1);
			}else {
				game.returnCard(2);
			}
			 game.returnCard(3);
		     game = dao.loadFromToken(game.getToken());
		     assertThat(game.getCurrentPlayer()).isEqualTo(0);

	    }
	 
	 

}
