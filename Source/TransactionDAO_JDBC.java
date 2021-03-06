//package event_ticketing;

import java.util.*;
import java.sql.*;

class TransactionDAO_JDBC implements TransactionDAO {
	Connection transactConnection;
	public TransactionDAO_JDBC(Connection conn)
	{
		this.transactConnection = conn;
	}
	public int getTotalTransaction()
	{
		Statement search = null;
		try
		{
			search = transactConnection.createStatement();
			ResultSet rs = search.executeQuery("select count(*) as num" +
					" from transactions");
			if(rs.next())
				return rs.getInt("num");
			else
				return -1;
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return -1;
		}
	}
	public Transaction getTransactionById(String trans_id)
	{
		Statement search = null;
		try
		{
			search = transactConnection.createStatement();
			String sqlstmt = "select * from transactions where trans_id='"
					+ trans_id + "';";
			ResultSet rs=search.executeQuery(sqlstmt);
			if(rs.next())
			{
				Transaction transact = new Transaction(rs.getString("trans_id"),
						rs.getString("user_id"), rs.getString("bank_id"));
				transact.setAmount(rs.getInt("amount"));
				transact.setTransDate(rs.getString("trans_date"));
				transact.setTransTime(rs.getString("trans_time"));
				return transact;
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
	public ArrayList<Transaction> getTransactionByBank(String bank_id)
	{
		Statement search = null;
		ArrayList<Transaction> transact = new ArrayList<Transaction>();
		try
		{
			search = transactConnection.createStatement();
			String sqlstmt = "select * from transactions where bank_id='"
					+ bank_id + "';";
			ResultSet rs=search.executeQuery(sqlstmt);
			if(rs==null)
			{
				System.out.println("No transaction commited under this bank");
				return null;
			}
			while(rs.next())
			{
				Transaction temp = new Transaction(rs.getString("trans_id"),
						rs.getString("user_id"), rs.getString("bank_id"));
				temp.setAmount(rs.getInt("amount"));
				temp.setTransDate(rs.getString("trans_date"));
				temp.setTransTime(rs.getString("trans_time"));
				transact.add(temp);
			}
			return transact;
		}
		catch (SQLException ex)
		{
			System.out.println("SqlException:" + ex.getMessage());
			return null;
		}
	}
	public Transaction performNewTransaction(String trans_id, 
			String user_id, String bank_id)
	{
		Transaction transact = new Transaction(trans_id, user_id, bank_id);
		return transact;
	}
	public boolean addTransaction(Transaction transact)
	{
		Statement insert = null;
		String insertComm = "insert into transactions values ('" +
		transact.getTransId() + "', '" + transact.getBankId() + "', '" +
				transact.getUserId() + "', '" + transact.getTransDate() +
				"', '" + transact.getTransTime() + "', " + transact.getAmount()
				+ ")";
		try
		{
			insert = transactConnection.createStatement();
			insert.executeUpdate(insertComm);
			System.out.println("Transaction added to the database");
			return true;
		}
		catch(SQLException ex)
		{
			System.out.println("Couldn't add Transaction" + ex.getMessage());
			return false;
		}
	}
	public boolean removeTransaction(String trans_id)
	{
		Statement remove = null;
		String deletecomm = "delete from transactions where trans_id='"
				+ trans_id + "';";
		try
		{
			remove = transactConnection.createStatement();
			remove.executeUpdate(deletecomm);
			return true;
		}
		catch(SQLException ex)
		{
			return false;
		}
	}
	public boolean removeTransactionForBank(String bank_id)
	{
		Statement remove = null;
		String deletecomm = "delete from transactions where bank_id='"
				+ bank_id + "';";
		try
		{
			remove = transactConnection.createStatement();
			remove.executeUpdate(deletecomm);
			return true;
		}
		catch(SQLException ex)
		{
			return false;
		}
	}
	public boolean removeTransactionByUser(String user_id)
	{
		Statement remove = null;
		String deletecomm = "delete from transactions where user_id='"
				+ user_id + "';";
		try
		{
			remove = transactConnection.createStatement();
			remove.executeUpdate(deletecomm);
			return true;
		}
		catch(SQLException ex)
		{
			return false;
		}
	}
}
