//package event_ticketing;

import java.util.*;

public interface TicketDAO {
	public Ticket getTicketById(String ticket_id);
	public ArrayList<Ticket> showTicketByEvent(String event_id);
	public ArrayList<Ticket> showTicketByTransaction(String trans_id);
	public int getTotalTickets();

	public boolean addTicket(Ticket tic);
	public boolean removeTicket(String ticket_id);	
}
