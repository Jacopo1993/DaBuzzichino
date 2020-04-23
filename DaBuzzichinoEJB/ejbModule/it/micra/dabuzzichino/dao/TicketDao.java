package it.micra.dabuzzichino.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import it.micra.dabuzzichino.model.Ticket;
//import it.micra.dabuzzichino.model.User;

@Stateless
public class TicketDao implements ITicketDao{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Ticket findTicket(int ticketId) throws Exception {
		Ticket ticket = em.find(Ticket.class, ticketId);
		return ticket;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getSendedTickets(String username)  throws Exception {
		return em.createQuery("SELECT t FROM Ticket AS t where t.sender = :username")
				.setParameter("username", username)
				.getResultList();
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getReceivedTickets(String username)  throws Exception {
		return em.createQuery("SELECT t FROM Ticket AS t where t.solved = :true AND t.receiver = :username")
				.setParameter("true",true)
				.setParameter("username", username)
				.getResultList();
	}	
	
	@Override
	public void addTicket(Ticket newT) throws Exception {
		em.persist(newT);
	}
		
	@Override
	public void solveTicket (int ticketID) throws Exception{
		Ticket newT = em.find(Ticket.class, ticketID);
		newT.setSolved(true);
		Date todaysDate = new Date();
	    DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    String testDateString = df2.format(todaysDate);
		newT.setClosingDate(testDateString);
		em.merge(newT);
//		String closingDate =  "chiusura";
//		(Date) em.createQuery("SELECT CURRENT_TIMESTAMP").getSingleResult();
	}
	
	@Override
	public void modifyTicket (Ticket toModify) throws Exception{
		Ticket newT = em.find(Ticket.class, toModify.getTicketId());
		newT.setSolved(toModify.getSolved());
		Date todaysDate = new Date();
	    DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    String testDateString = df2.format(todaysDate);
		newT.setClosingDate(testDateString);
		em.merge(newT);
	}
	
	@Override
	public String getTime() throws Exception  {
		return (String) em.createQuery("SELECT CURRENT_TIMESTAMP").getSingleResult();	
	}
	
	@Override
	public String getUser() throws Exception  {
		String User = "Test User";
		return User;	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getUnsolvedTicket(String username)  throws Exception {
		return em.createQuery("SELECT t FROM Ticket AS t WHERE t.solved = :false AND t.receiver = :username")
				.setParameter("false",false)
				.setParameter("username", username)
				.getResultList();
	}	
	
	
	
//	@Override
//	public void deleteTicket(Ticket oldT) throws Exception  {
//		Ticket t = em.find(Ticket.class,oldT.getTicketId());
//		em.remove(t);
//	}

}
