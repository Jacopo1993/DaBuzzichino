package it.micra.dabuzzichino.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.micra.dabuzzichino.model.User;

@Stateless
public class UserDao implements IUserDao{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public boolean login(String username, String password) {
		User guest = (User) em.createQuery("select user from User user where user.username = :username AND user.password = :password")
				.setParameter("username", username).setParameter("password", password)
				.getSingleResult();
		if (guest == null)
			return false;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers(String username)  throws Exception {
		return em.createQuery("SELECT u.username FROM User AS u where u.username <> :username")
				.setParameter("username",username)
				.getResultList();
	}	
}
