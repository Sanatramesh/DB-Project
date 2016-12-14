//package event_ticketing;

import java.sql.*;
import java.util.ArrayList;


public class Event_UploaderDAO_JDBC implements Event_UploaderDAO {																																																																																																																																																																																																																															     
	Connection dbConnection = null;
	AccountDAO accounts = null;
	public Event_UploaderDAO_JDBC(Connection dbconn){
		dbConnection = dbconn;
	}

	

	public ArrayList<Event_Uploader> getEvent_UploaderByOrgId(String org_id)
	{
		String sqlstmt;
		Statement search = null;
		ArrayList<Event_Uploader> tick = new ArrayList<Event_Uploader>();
		try
		{
			search = dbConnection.createStatement();
			sqlstmt = "select * from account_event_manager where org_id='" + org_id + "';";
			ResultSet rs=search.executeQuery(sqlstmt);
			if(rs==null)
			{
				System.out.println("No Event_Uploader under this name");
				return null;
			}
			while(rs.next())
			{
				Event_Uploader up = new Event_Uploader(rs.getString("event_manager_id"), rs.getString("org_id"), rs.getString("organisation"));
				up = this.getAccountByEvent_Uploader(up);
				tick.add(up);
			}
			return tick;
		}
		catch (SQLException ex)
		{
			System.out.println("SqlException:" + ex.getMessage());
			return null;
		}
	}

	public  ArrayList<Event_Uploader> getEvent_UploaderByOrgName(String org_name) 
	{
		String sqlstmt;
		Statement stmt = null;
		ArrayList<Event_Uploader> tick = new ArrayList<Event_Uploader>();
		try
		{
			stmt = dbConnection.createStatement();
			sqlstmt = "select * from account_event_manager where organisation='" + org_name + "';";
			ResultSet rs=stmt.executeQuery(sqlstmt);
			if(rs==null)
			{
				System.out.println("No Event_Uploader under this name");
				return null;
			}
			while(rs.next())
			{
				Event_Uploader up = new Event_Uploader(rs.getString("event_manager_id"), rs.getString("org_id"), rs.getString("organisation"));
				up = this.getAccountByEvent_Uploader(up);
				tick.add(up);
			}
			return tick;
		}
		catch (SQLException ex)
		{
			System.out.println("SqlException:" + ex.getMessage());
			return null;
		}
	}

	public Event_Uploader getEvent_UploaderByMgrId(String event_manager_id)
	{
		String sqlstmt;
		Statement stmt = null;
		try
		{
			stmt = dbConnection.createStatement();
			sqlstmt = "select * from account_event_manager where event_manager_id='" + event_manager_id + "';";
			ResultSet rs=stmt.executeQuery(sqlstmt);
			if(rs.next())
			{
				Event_Uploader temp = new Event_Uploader(rs.getString("event_manager_id"), rs.getString("org_id"), rs.getString("organisation"));
				temp = this.getAccountByEvent_Uploader(temp);
				return temp;
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
	
	public Event_Uploader getAccountByEvent_Uploader(Event_Uploader uploader) {
		this.accounts = new AccountDAO_JDBC(dbConnection);
		Account acc = accounts.getAccountById(uploader.getEvent_manager_id());
		uploader.setAccountId(acc.getAccountId());
		uploader.setAccounttype(acc.getAccounttype());
		uploader.setAddress(acc.getAddress());
		uploader.setAdminacc(acc.getAdminacc());
		uploader.setBdate(acc.getBdate());
		uploader.setEmail(acc.getBdate());
		uploader.setFname(acc.getFname());
		uploader.setLname(acc.getLname());
		uploader.setMinit(acc.getMinit());
		uploader.setPassword(acc.getPassword());
		uploader.setSex(acc.getSex());
		return uploader;
	}

	public boolean addEvent_Uploader(Event_Uploader uploader) {
		Statement insert = null;
		String insertComm = "insert into Event_Uploader VALUES ('"+uploader.getEvent_manager_id() + "', '"  + uploader.getOrganization_id() + "', '" + uploader.getOrganization_name()  + "');";
		try
		{
			insert = dbConnection.createStatement();
			insert.executeUpdate(insertComm);
			System.out.println("Event_Uploader added to the database");
			return true;
		}
		catch(SQLException ex)
		{
			System.out.println("Couldn't add Ticket" + ex.getMessage());
			return false;
		}
	}

	public boolean deleteEvent_Uploader(String org_id)
	{
		Statement remove = null;
		String deletecomm = "delete from Event_Uploader where org_id='" + org_id + "';";
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
