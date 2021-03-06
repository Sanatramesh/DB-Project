//package event_ticketing;

import java.sql.*;

public class Books_ForDAO_JDBC implements Books_ForDAO {
	Connection dbConnection = null;
	public Books_ForDAO_JDBC(Connection conn)
	{
		dbConnection = conn;
	}
	public void addUserEvent(String user_id, String event_id)
	{
		String select = "select count(*) num from books_for;";
		try
		{
			Statement insertStmt = dbConnection.createStatement();
			ResultSet rs = insertStmt.executeQuery(select);
			int count = -1;
			if(rs.next())
				count = rs.getInt("num");
			String id = Integer.toString(++count);
			while(id.length()<8)
				id = "0" + id;
			id = "BF" + id;
			String insert = "insert into books_for values ('" + id + "', '" 
			+ event_id + "', '" + user_id +"');"; 
			insertStmt.executeUpdate(insert);
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void deleteUserEvent(String user_id, String event_id)
	{
		String delete = "delete from books_for where event_id='" + event_id
				+ "' and usr_id='" + user_id +"');";
		try
		{
			Statement deleteStmt = dbConnection.createStatement();
			deleteStmt.executeUpdate(delete);
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
	
}
