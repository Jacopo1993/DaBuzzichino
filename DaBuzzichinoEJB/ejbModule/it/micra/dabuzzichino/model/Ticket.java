package it.micra.dabuzzichino.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Ticket implements Serializable{
	@Column (name= "ticketId", nullable = false)		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	private Integer ticketId;
	@Column (name= "sender", nullable = false)
    private String sender;
	@Column (name= "receiver", nullable = false)
    private String receiver;
	@Column (name= "ticketValue", nullable = false)
    private String ticketValue;
	@Column (name= "solved", nullable = false)
    private Boolean solved;
	@Column (name= "releaseDate", nullable = false)
//	@Temporal(TemporalType.TIMESTAMP)
    private String releaseDate;
	@Column (name= "closingDate", nullable = true)
//	@Temporal(TemporalType.TIMESTAMP)
    private String closingDate;
	@Column (name= "message", nullable = true)
    private String message;
	
	
	public Ticket() {
	}
    	    	    
    public Ticket( String sender, String receiver, 
    		String ticketValue, Boolean solved, 
    		String releaseDate, String closingDate, 
    		String message){          
        this.sender = sender;
        this.receiver = receiver;
        this.ticketValue = ticketValue;
        this.solved = solved;
        this.releaseDate = releaseDate;
        this.closingDate = closingDate;
        this.message = message;
    }
    
    public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	public String getClosingDate() {
		return closingDate;
	}
	
	public void setClosingDate(String closingDate2) {
		this.closingDate = closingDate2;
	}  
	
	public String getTicketValue() {
		return ticketValue;
	}
	
	public void setTicketValue(String ticketValue) {
		this.ticketValue = ticketValue;
	}

	
	public String getReleaseDate() {
		return releaseDate;
	
	}
	
	public void setReleaseDate(String string) {
		this.releaseDate = string;
	}
		
	public Boolean getSolved() {
		return solved;
	
	}
	
	public void setSolved(Boolean solved) {
		this.solved = solved;
	}
	
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}