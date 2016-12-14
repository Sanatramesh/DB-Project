//package event_ticketing;

import java.util.*;
import java.sql.*;

public class Bank_DAO_JDBC implements Bank_DAO {
	
	Connection dbConnection = null;
	TransactionDAO transactions = null;
	public Bank_DAO_JDBC(Connection conn)
	{
		dbConnection = conn;
	}
	public Bank getBankById(String bank_id)
	{
		String selectStmt = "select * from bank where bank_id='"
		+ bank_id + "';";
		Statement select = null;
		try
		{
			select = dbConnection.createStatement();
			ResultSet rs = select.executeQuery(selectStmt);
			if(rs.next())
			{
				Bank theBank = new Bank();
				theBank.setBank_id(rs.getString("bank_id"));
				theBank.setBank_name(rs.getString("bank_name"));
				theBank.setBank_address(rs.getString("bank_addr"));
				return theBank; 
			}
			else
				return null;
		}
		catch(SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    return null;
		}
	}
	
	public ArrayList<Bank> getBankByName(String bank_name)
	{
		ArrayList<Bank> banks = new ArrayList<Bank>();
		String selectStmt = "select * from bank where bank_name='"
		+ bank_name + "';";
		Statement select = null;
		try
		{
			select = dbConnection.createStatement();
			ResultSet rs = select.executeQuery(selectStmt);
			while(rs.next())
			{
				Bank theBank = new Bank();
				theBank.setBank_id(rs.getString("bank_id"));
				theBank.setBank_name(rs.getString("bank_name"));
				theBank.setBank_address(rs.getString("bank_addr"));
				banks.add(theBank);
			}
		}
		catch(SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    return null;
		}
		return banks;
	}
	
	public ArrayList<Bank> getBankByAddress(String bank_address)
	{
		ArrayList<Bank> banks = new ArrayList<Bank>();
		String selectStmt = "select * from bank where bank_addr='"
		+ bank_address + "';";
		Statement select = null;
		try
		{
			select = dbConnection.createStatement();
			ResultSet rs = select.executeQuery(selectStmt);
			while(rs.next())
			{
				Bank theBank = new Bank();
				theBank.setBank_id(rs.getString("bank_id"));
				theBank.setBank_name(rs.getString("bank_name"));
				theBank.setBank_address(rs.getString("bank_addr"));
				banks.add(theBank);
			}
		}
		catch(SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    return null;
		}
		return banks;
	}
	
	public void getTransactionByBank(String bank_id)
	{
		this.transactions = new TransactionDAO_JDBC(dbConnection);
		ArrayList<Transaction> transacts = 
				transactions.getTransactionByBank(bank_id);
		if(transacts!=null)
		{
			for(int i=0; i<transacts.size(); i++)
			{
				Transaction theTransact = transacts.get(i);
				theTransact.showTransaction();
			}
		}
	}
	
	
	public void removeBank(Bank bank)
	{
		String deleteStmt = "delete from bank where bank_id='"
				+ bank.getBank_id() + "';";
		Statement delete = null;
		try
		{
			delete = dbConnection.createStatement();
			delete.executeUpdate(deleteStmt);
		}
		catch(SQLException ex)
		{
			 System.out.println("SQLException: " + ex.getMessage());
			 System.out.println("SQLState: " + ex.getSQLState());
			 System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public void addBank(Bank bank)
	{
		String insertStmt = "insert into bank (bank_id, bank_name, "
				+ "bank_address values ('" + bank.getBank_id() + "', '"
				+ bank.getBank_name() + "', '" + bank.getBank_address() +"');";
		Statement insert = null;
		try
		{
			insert = dbConnection.createStatement();
			insert.executeUpdate(insertStmt);
		}
		catch(SQLException ex)
		{
			 System.out.println("SQLException: " + ex.getMessage());
			 System.out.println("SQLState: " + ex.getSQLState());
			 System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public void showBanks(ArrayList<Bank> banks)
	{
		for(int i=0; i<banks.size(); i++)
		{
			Bank theBank = banks.get(i);
			theBank.showBankDetail();
		}
	}
}
