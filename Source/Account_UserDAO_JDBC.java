//package event_ticketing;

import java.sql.*;
import java.util.*;

public class Account_UserDAO_JDBC {
	private Connection dbConnection = null;
	public Account_UserDAO_JDBC(Connection dbConn)
	{
		dbConnection = dbConn;
	}
	public ArrayList<Account_User> getAccountByName(String Fname)
	{
		ArrayList<Account_User> acc_list = new ArrayList<Account_User>();
		Account_User acc = new Account_User();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Account where fname='"+Fname+"';";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				String AccountId = rs.getString("AccountId");
				String Email = rs.getString("email");
				String Password = rs.getString("password");
				String Minit = rs.getString("minit");
				String Lname = rs.getString("lname");
				String Bdate = rs.getString("bdate");
				String Address = rs.getString("address");
				char Sex = rs.getString("sex").toCharArray()[0];
				int Account_type = rs.getInt("account_type");
				String Admin_account = rs.getString("admin_acc");
				
				acc.setAccountId(AccountId);
				acc.setEmail(Email);
				acc.setPassword(Password);
				acc.setFname(Fname);
				acc.setMinit(Minit);
				acc.setLname(Lname);
				acc.setBdate(Bdate);
				acc.setAddress(Address);
				acc.setSex(Sex);
				acc.setAccounttype(Account_type);
				acc.setAdminacc(Admin_account);
				
				acc_list.add(acc);
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return acc_list;
	}
	public Account_User getAccountById(String AccountId)
	{
		Account_User acc = new Account_User();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Account where AccountId='"+AccountId+"';";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				String Email = rs.getString("email");
				String Password = rs.getString("password");
				String Fname = rs.getString("fname");
				String Minit = rs.getString("minit");
				String Lname = rs.getString("lname");
				String Bdate = rs.getString("bdate");
				String Address = rs.getString("address");
				char Sex = rs.getString("sex").toCharArray()[0];
				int Account_type = rs.getInt("account_type");
				String Admin_account = rs.getString("admin_acc");
				
				acc.setAccountId(AccountId);
				acc.setEmail(Email);
				acc.setPassword(Password);
				acc.setFname(Fname);
				acc.setMinit(Minit);
				acc.setLname(Lname);
				acc.setBdate(Bdate);
				acc.setAddress(Address);
				acc.setSex(Sex);
				acc.setAccounttype(Account_type);
				acc.setAdminacc(Admin_account);
				
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return acc;
	}
	public Account_User getAccountByEmail(String Email)
	{
		Account_User acc = new Account_User();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Account where Email='"+Email+"';";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				String AccountId = rs.getString("AccountId");
				String Password = rs.getString("password");
				String Fname = rs.getString("fname");
				String Minit = rs.getString("minit");
				String Lname = rs.getString("lname");
				String Bdate = rs.getString("bdate");
				String Address = rs.getString("address");
				char Sex = rs.getString("sex").toCharArray()[0];
				int Account_type = rs.getInt("account_type");
				String Admin_account = rs.getString("admin_acc");
				
				acc.setAccountId(AccountId);
				acc.setEmail(Email);
				acc.setPassword(Password);
				acc.setFname(Fname);
				acc.setMinit(Minit);
				acc.setLname(Lname);
				acc.setBdate(Bdate);
				acc.setAddress(Address);
				acc.setSex(Sex);
				acc.setAccounttype(Account_type);
				acc.setAdminacc(Admin_account);
				
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return acc;
	}
	public ArrayList<Account_User> getAccountByAccounttype(int Accounttype)
	{
		ArrayList<Account_User> acc_list = new ArrayList<Account_User>();
		Account_User acc = new Account_User();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Account where account_type="+Accounttype+";";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				String AccountId = rs.getString("AccountId");
				String Email = rs.getString("email");
				String Password = rs.getString("password");
				String Fname = rs.getString("fname");
				String Minit = rs.getString("minit");
				String Lname = rs.getString("lname");
				String Bdate = rs.getString("bdate");
				String Address = rs.getString("address");
				char Sex = rs.getString("sex").toCharArray()[0];
				int Account_type = rs.getInt("account_type");
				String Admin_account = rs.getString("admin_acc");
				
				acc.setAccountId(AccountId);
				acc.setEmail(Email);
				acc.setPassword(Password);
				acc.setFname(Fname);
				acc.setMinit(Minit);
				acc.setLname(Lname);
				acc.setBdate(Bdate);
				acc.setAddress(Address);
				acc.setSex(Sex);
				acc.setAccounttype(Account_type);
				acc.setAdminacc(Admin_account);
				
				acc_list.add(acc);
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return acc_list;
	}
	
	public void addAccount(Account_User account)
	{
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "insert into account(AccountId,email,password,fname,minit,lname,bdate,address,sex,account_type,admin_acc) "+
			"VALUES("+account.getAccountId()+","+account.getEmail()+","+account.getPassword()+","+account.getFname()+","+account.getMinit()+","+account.getLname()+","+account.getBdate()+","+account.getAddress()+","+account.getSex()+","+account.getAccounttype()+","+account.getAdminacc()+" );";
			stmt.executeUpdate(sql);

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	public void removeAccount(Account_User account)
	{
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "delete from account where AccountId='"+account.getAccountId()+"';";
			stmt.executeUpdate(sql);
		
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

}
