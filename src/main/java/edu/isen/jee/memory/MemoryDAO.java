package edu.isen.jee.memory;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.commons.lang.RandomStringUtils;

public class MemoryDAO implements Serializable {

	@Inject
	EntityManager em;

	@Inject
	UserTransaction ut;

	/*
	 * public MemoryDAO(){ System.out.println("DAO creation"); }
	 */

	public MemoryAdapter createNewGame() {
		Game game = new Game();
		game.setToken(RandomStringUtils.randomAlphanumeric(10).toLowerCase());
		try {
			ut.begin();
			em.persist(game);
			ut.commit();

		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			return null;
		}
		return new MemoryAdapter(this, game);
	}

	public MemoryAdapter loadFromToken(String token) {
		Game game = (Game) em.createQuery("SELECT g FROM Game g WHERE g.token = :token").setParameter("token", token)
				.getSingleResult();

		return new MemoryAdapter(this, game);
	}

	public void save(Game game) {
		try {
			ut.begin();
			em.merge(game);
			ut.commit();
		} catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
				| HeuristicRollbackException | SystemException | NotSupportedException e) {
			e.printStackTrace();
		}

	}
}
