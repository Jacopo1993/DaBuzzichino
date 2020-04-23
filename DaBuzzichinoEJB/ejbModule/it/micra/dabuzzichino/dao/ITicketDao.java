package it.micra.dabuzzichino.dao;

import java.util.List;

import it.micra.dabuzzichino.model.Ticket;

public interface ITicketDao {

	

	void addTicket(Ticket newT) throws Exception;

	Ticket findTicket(int ticketId) throws Exception;

//	void deleteTicket(Ticket oldt) throws Exception;

	String getTime() throws Exception;

	String getUser() throws Exception;

	void solveTicket(int ticketID) throws Exception;

	List<Ticket> getSendedTickets(String username) throws Exception;

	List<Ticket> getReceivedTickets(String username) throws Exception;

	List<Ticket> getUnsolvedTicket(String username) throws Exception;

	void modifyTicket(Ticket toModify) throws Exception;

}
