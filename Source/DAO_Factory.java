//package event_ticketing;
//import java.io.*;
import java.sql.*;
/*
	Methods to be called in the following order:

	1. activateConnection
	2. 	Any number getDAO calls with any number of database transactions
	3. deactivateConnection
*/
public class DAO_Factory{
	
	public enum TXN_STATUS { COMMIT, ROLLBACK };
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/event_ticketing";
	static final String USER = "root";
	static final String PASS = "thanks";
	Connection dbconnection = null;

	// You can add additional DAOs here as needed
	EventDAO eventDAO = null;
	TransactionDAO transactionDAO = null;
	Bank_DAO bankDAO = null;
	AccountDAO accountDAO = null;
	Event_UploaderDAO event_uploderDAO = null;
	TicketDAO ticketDAO = null;
	Books_ForDAO books_forDAO = null;
	
	boolean activeConnection = false;

	public DAO_Factory()
	{
		dbconnection = null;
		activeConnection = false;
	}

	public void activateConnection() throws Exception
	{
		if( activeConnection == true )
			throw new Exception("Connection already active");

		System.out.println("Connecting to database...");
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			dbconnection = DriverManager.getConnection(DB_URL,USER,PASS);
			dbconnection.setAutoCommit(false);
			activeConnection = true;
		} catch(ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public Books_ForDAO getBooks_ForDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( this.books_forDAO == null )
			this.books_forDAO = new Books_ForDAO_JDBC( dbconnection );

		return this.books_forDAO;
	}
	
	public EventDAO getEventDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( eventDAO == null )
			eventDAO = new EventDAO_JDBC( dbconnection );

		return eventDAO;
	}
	
	public TransactionDAO getTransactionDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( transactionDAO == null )
			transactionDAO = new TransactionDAO_JDBC( dbconnection );

		return transactionDAO;
	}
	public AccountDAO getAccountDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( accountDAO == null )
			accountDAO = new AccountDAO_JDBC( dbconnection );

		return accountDAO;
	}
	public TicketDAO getTicketDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( ticketDAO == null )
			ticketDAO = new TicketDAO_JDBC( dbconnection );

		return ticketDAO;
	}
	public Event_UploaderDAO getEventUploderDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( event_uploderDAO == null )
			event_uploderDAO = new Event_UploaderDAO_JDBC( dbconnection );

		return event_uploderDAO;
	}
	
	public Bank_DAO getBankDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( bankDAO == null )
			bankDAO = new Bank_DAO_JDBC( dbconnection );

		return bankDAO;
	}
	public void deactivateConnection(TXN_STATUS txn_status)
	{
		// Okay to keep deactivating an already deactivated connection
		activeConnection = false;
		if( dbconnection != null ){
			try{
				if( txn_status == TXN_STATUS.COMMIT )
					dbconnection.commit();
				else
					dbconnection.rollback();
					
				dbconnection.close();
				dbconnection = null;
			}
			catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
	}
}
