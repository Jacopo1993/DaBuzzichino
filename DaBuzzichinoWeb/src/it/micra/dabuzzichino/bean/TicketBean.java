package it.micra.dabuzzichino.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

//import org.primefaces.event.RowEditEvent;

import it.micra.dabuzzichino.dao.ITicketDao;
import it.micra.dabuzzichino.dao.IUserDao;
//import it.micra.dabuzzichino.dao.IUserDao;
import it.micra.dabuzzichino.model.Ticket;
import it.micra.dabuzzichino.model.User;

@ManagedBean(name = "ticketbean")
@SessionScoped
public class TicketBean {
	@EJB
	private ITicketDao ticketDao;	
	@EJB
	private IUserDao userDao;
	
	private Ticket toInsert = new Ticket();

	private List<Ticket> sendedTickets;
	
	private List<Ticket> receivedTickets;
	
	private List<User> users;
	
	private List<Ticket> unsolvedTicket;
	
	private int idToSolve;
	
	private String username = "pablo";
	
	private String branchTest = "branch_01";
	
	@PostConstruct
	public void init() {
	
		try {	
			returnAllUsers(username);
			returnAllSendedTickets(username);
			returnAllReceivedTickets(username);						
			
			returnAllUnsolvedTicket(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void returnAllUsers(String username) throws Exception {
		setUsers((List<User>) userDao.getUsers(username));
	}
	
	public void returnAllUnsolvedTicket(String username) throws Exception {
		setUnsolvedTicket((List<Ticket>) ticketDao.getUnsolvedTicket( username));
	}
	
	public void returnAllSendedTickets(String username) throws Exception {
		setSendedTickets((List<Ticket>) ticketDao.getSendedTickets(username));
	}
	
	public void returnAllReceivedTickets(String username) throws Exception {
		setReceivedTickets((List<Ticket>) ticketDao.getReceivedTickets(username));
	}
	
	public String addTicket() {
		try {
			toInsert.setSender(username);
			Date todaysDate = new Date();
		    DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		    String testDateString = df2.format(todaysDate);
			toInsert.setReleaseDate(testDateString);
			toInsert.setSolved(false);
			ticketDao.addTicket(toInsert);
			returnAllSendedTickets(username);
			return "sendedticketstablepage";
		} catch (Exception e) {
			e.printStackTrace();			
			return "home";
		} finally {
			toInsert= new Ticket();
		}
	}
		
	public void solveTicket() {
		try {
			ticketDao.solveTicket(idToSolve);
			returnAllSendedTickets(username);
//			return "home";
//				return "receivedticketstablepage";
		} catch (Exception e) {
			e.printStackTrace();
//			return "home";
		} finally {
			idToSolve = 0;
		}
	}
	
	public Ticket getToInsert() {
		return toInsert;
	}

	public void setToInsert(Ticket toInsert) {
		this.toInsert = toInsert;
	}
	
	public List<Ticket> getSendedTickets() {
		return sendedTickets;
	}

	public void setSendedTickets(List<Ticket> tickets) {
		this.sendedTickets = tickets;
	}
	
	public String getSendedTicketsTablePageUrl() {
		return "sendedticketstablepage";
	}
	
	public String getReceivedTicketsTablePageUrl() {
		return "receivedticketstablepage";
	}

	public String getHomePageUrl() {
		return "home";
	}

	public List<Ticket> getReceivedTickets() {
		return receivedTickets;
	}

	public void setReceivedTickets(List<Ticket> receivedTickets) {
		this.receivedTickets = receivedTickets;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getIdToSolve() {
		return idToSolve;
	}

	public void setIdToSolve(int idToSolve) {
		this.idToSolve = idToSolve;
	}

	public List<Ticket> getUnsolvedTicket() {
		return unsolvedTicket;
	}

	public void setUnsolvedTicket(List<Ticket> unsolvedTicket) {
		this.unsolvedTicket = unsolvedTicket;
	}
	
	public void onRowEdit(RowEditEvent event) {
		try {
				ticketDao.modifyTicket((Ticket)event.getObject());
				returnAllReceivedTickets(username);						
				returnAllUnsolvedTicket(username);
		} catch (Exception e) {
				e.printStackTrace();
		}		
	}
	
//	public String deleteTicket(Ticket oldT) {
//	try {
//		ticketDao.deleteTicket(oldT);
//		returnAllSendedTickets();
//		return "ticketsTablePage";
//
//	} catch (Exception e) {
//		e.printStackTrace();
//		return "eliminazione fallita";
//	}
//}
}
