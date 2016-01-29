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

}
