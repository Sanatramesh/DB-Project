//package event_ticketing;
import java.util.*;
import java.sql.*;


public class EventDAO_JDBC implements EventDAO {

	Connection dbConnection = null;
	
	public EventDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
 		
		dbConnection = dbconn;
	}
	@Override
	public int getTotalEvent()
	{
		Statement search = null;
		try
		{
			search = dbConnection.createStatement();
			ResultSet rs = search.executeQuery("select count(*) as num" +
					" from event");
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
	
	@Override
	public ArrayList<Event> getEventByName(String Name){
		ArrayList<Event> e_list = new ArrayList<Event>();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from event where name='"+Name+"';";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				Event e = new Event();
				String id = rs.getString("event_id");
				String name = rs.getString("name");
				String date = rs.getString("event_date");
				String desc = rs.getString("event_desc");
				int price = rs.getInt("ticket_price");
				int size = rs.getInt("max_size");
				int avail_seat = rs.getInt("avail_size");
				String addr = rs.getString("event_addr");
				String mgrid = rs.getString("manager_id");
				String t = rs.getString("time_t");
				
				e.setId(id);
				e.setName(name);
				e.setDate(date);
				e.setDesc(desc);
				e.setPrice(price);
				e.setCapacity(size);
				e.setAvailableSeat(avail_seat);
				e.setManagerId(mgrid);
				e.setAddr(addr);
				e.setTime(t);
				
				e_list.add(e);
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return e_list;
	}
	
	@Override
	public ArrayList<Event> getEventByDate(String Date){
		ArrayList<Event> e_list = new ArrayList<Event>();
		Event e = null;
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from event where event_date='"+Date+"';";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				String id = rs.getString("event_id");
				String name = rs.getString("name");
				String date = rs.getString("event_date");
				String desc = rs.getString("event_desc");
				int price = rs.getInt("ticket_price");
				int size = rs.getInt("max_size");
				int avail_seat = rs.getInt("avail_size");
				String addr = rs.getString("event_addr");
				String mgrid = rs.getString("manager_id");
				String t = rs.getString("time_t");
				e = new Event();
				e.setId(id);
				e.setName(name);
				e.setDate(date);
				e.setDesc(desc);
				e.setPrice(price);
				e.setCapacity(size);
				e.setAvailableSeat(avail_seat);
				e.setManagerId(mgrid);
				e.setAddr(addr);
				e.setTime(t);
				
				e_list.add(e);
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		//System.out.println("Size"+e_list.size());
		return e_list;
	}
	
	@Override
	public ArrayList<Event> getEventByMgrId(String eve_mgr_id){
		ArrayList<Event> e_list = new ArrayList<Event>();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from event where manager_id='"+eve_mgr_id+"';";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				Event e = new Event();
				//Retrieve by column name
				String id = rs.getString("event_id");
				String name = rs.getString("name");
				String date = rs.getString("event_date");
				String desc = rs.getString("event_desc");
				int price = rs.getInt("ticket_price");
				int size = rs.getInt("max_size");
				int avail_seat = rs.getInt("avail_size");
				String addr = rs.getString("event_addr");
				String mgrid = rs.getString("manager_id");
				String t = rs.getString("time_t");
				
				e.setId(id);
				e.setName(name);
				e.setDate(date);
				e.setDesc(desc);
				e.setPrice(price);
				e.setCapacity(size);
				e.setAvailableSeat(avail_seat);
				e.setManagerId(mgrid);
				e.setAddr(addr);
				e.setTime(t);
				
				e_list.add(e);
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return e_list;
	
	}
	
	@Override
	public void addEvent(Event event){
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "insert into event(event_id,name,event_date,event_desc," +
					"event_addr,manager_id, ticket_price, max_size, avail_size" +
					") VALUES('" + event.getId() + "', '" + event.getName()
					+ "', '" + event.getDate() + "', '" + event.getDesc()
					+ "', '" + event.getAddr() + "', '" + event.getManagerId()
					+ "', '" + event.getPrice() + "', '" + event.getCapacity()
					+ "', '" + event.getAvailableSeat() + "' );";
			stmt.executeUpdate(sql);
			System.out.println("Event added");

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record	
	}
	
	@Override
	public void updateEvent(Event event){
		String updateStmt;
		Statement update = null;
		try
		{
			updateStmt = "update event set event_id='" + event.getId()
					+ "', name='" + event.getName() + "', event_date='"
					+ event.getDate() + "', manager_id='" + event.getManagerId()
					+ "', event_desc='" + event.getDesc() + "', event_addr='"
					+ event.getAddr() + "', time_t='" + event.getTime()
					+ "', max_size=" + event.getCapacity() + ", avail_size="
					+ event.getAvailableSeat() + " where event_id='"
					+ event.getId() + "';";
			update = dbConnection.createStatement();
			update.executeUpdate(updateStmt);
		}
		catch(SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	@Override
	public void removeEvent(Event event){
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "delete from event where event_id='"+event.getId()+"';";
			stmt.executeUpdate(sql);
		
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record		
	}
	
	@Override
	public Event getEventById(String eid) {
		Event e = new Event();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from event where event_id='"+eid+"';";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				String id = rs.getString("event_id");
				String name = rs.getString("name");
				String date = rs.getString("event_date");
				String desc = rs.getString("event_desc");
				int price = rs.getInt("ticket_price");
				int size = rs.getInt("max_size");
				int avail_seat = rs.getInt("avail_size");
				String addr = rs.getString("event_addr");
				String mgrid = rs.getString("manager_id");
				String t = rs.getString("time_t");
				
				e.setId(id);
				e.setName(name);
				e.setDate(date);
				e.setDesc(desc);
				e.setPrice(price);
				e.setCapacity(size);
				e.setAvailableSeat(avail_seat);
				e.setManagerId(mgrid);
				e.setAddr(addr);
				e.setTime(t);
				break;
				// Add exception handling here if more than one row is returned
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return e;
	}
}
