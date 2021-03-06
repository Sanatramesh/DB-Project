//package event_ticketing;

import java.util.*;
import java.sql.*;

public class TicketDAO_JDBC implements TicketDAO {
	Connection dbConnection;

	public TicketDAO_JDBC(Connection dbconn){
		dbConnection = dbconn;
	}
	
	public int getTotalTickets()
	{
		Statement search = null;
		try
		{
			search = dbConnection.createStatement();
			ResultSet rs = search.executeQuery("select count(*) as num" +
					" from ticket");
			if(rs.next())
				return rs.getInt("num");
			else
				return -1;
		}
		catch(SQLException ex)
		{
			System.out.println("SqlException: " + ex.getMessage());
			return -1;
		}
		
	}

	public Ticket getTicketById(String ticket_id)
	{
		String sqlstmt;
		Statement search = null;
		try
		{
			search = dbConnection.createStatement();
			sqlstmt = "select * from ticket where ticket_id='" + ticket_id + "';";
			ResultSet rs=search.executeQuery(sqlstmt);
			if(rs.next())
			{
				Ticket tick = new Ticket(rs.getString("ticket_id"), rs.getString("event_id"), rs.getString("trans_id"));
				tick.setCost(rs.getInt("cost"));
				tick.setSeat_no(rs.getInt("seat_no"));
				return tick;
			}
			else
				return null;
		}
		catch (SQLException ex)
		{
			System.out.println("SqlException:" + ex.getMessage());
			return null;
		}
	}

	public ArrayList<Ticket> showTicketByEvent(String event_id)
	{
		String sqlstmt;
		Statement search = null;
		ArrayList<Ticket> tick = new ArrayList<Ticket>();
		try
		{
			search = dbConnection.createStatement();
			sqlstmt = "select * from ticket where event_id='" + event_id + "';";
			ResultSet rs=search.executeQuery(sqlstmt);
			if(rs==null)
			{
				System.out.println("No tickets under this events");
				return null;
			}
			while(rs.next())
			{
				Ticket temp = new Ticket(rs.getString("ticket_id"),rs.getString("event_id"), rs.getString("trans_id"));
				temp.setCost(rs.getInt("cost"));
				temp.setSeat_no(rs.getInt("seat_no"));
				tick.add(temp);
			}
			return tick;
		}
		catch (SQLException ex)
		{
			System.out.println("SqlException:" + ex.getMessage());
			return null;
		}
	}
	public ArrayList<Ticket>showTicketByTransaction(String trans_id)
	{
		String sqlstmt;
		Statement search = null;
		ArrayList<Ticket> tick = new ArrayList<Ticket>();
		try
		{
			search = dbConnection.createStatement();
			sqlstmt = "select * from ticket where trans_id='"
					+ trans_id + "';";
			ResultSet rs=search.executeQuery(sqlstmt);
			if(rs==null)
			{
				System.out.println("No tickets under this transaction");
				return null;
			}
			while(rs.next())
			{
				Ticket temp = new Ticket(rs.getString("ticket_id"),rs.getString("event_id"), rs.getString("trans_id"));
				temp.setCost(rs.getInt("cost"));
				temp.setSeat_no(rs.getInt("seat_no"));
				tick.add(temp);
			}
			return tick;
		}
		catch (SQLException ex)
		{
			System.out.println("SqlException:" + ex.getMessage());
			return null;
		}
	}

	
	public boolean addTicket(Ticket tick)
	{
		Statement insert = null;
		String insertComm = "insert into ticket values ('"
		+ tick.getTicket_id() + "', '" + tick.getEvent_id()
		+ "', '" + tick.getCost() + "', '" + tick.getTrans_id()
		+ "', '" + tick.getSeat_no() + "');";
		try
		{
			insert = dbConnection.createStatement();
			insert.executeUpdate(insertComm);
			System.out.println("Ticket added to the database");
			return true;
		}
		catch(SQLException ex)
		{
			System.out.println("Couldn't add Ticket" + ex.getMessage());
			return false;
		}
	}

	public boolean removeTicket(String ticket_id)
	{
		Statement remove = null;
		String deletecomm = "delete from ticket where ticket_id='" + ticket_id + "';";
		try
		{
			remove = dbConnection.createStatement();
			remove.executeUpdate(deletecomm);
			return true;
		}
		catch(SQLException ex)
		{
			return false;
		}
	}
	
	
}
