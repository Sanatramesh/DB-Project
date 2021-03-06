//package event_ticketing;

import java.sql.*;
import java.util.*;

public class AccountDAO_JDBC implements AccountDAO{
	private Connection dbConnection = null;
	public AccountDAO_JDBC(Connection dbconn)
	{
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}
	
	public ArrayList<Account> getAccountByName(String Fname){
		ArrayList<Account> acc_list = new ArrayList<Account>();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from account where fname='"+Fname+"';";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				Account acc = new Account();
				String AccountId = rs.getString("acc_id");
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
	
	
	
	public Account getAccountById(String AccountId){
		Account acc = new Account();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from account where acc_id='"+AccountId+"';";
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
				break;
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
	
	
	public Account getAccountByEmail(String Email){
		Account acc = new Account();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from account where email='"+Email+"';";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				String AccountId = rs.getString("acc_id");
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
				break;
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
	
	
	
	public ArrayList<Account> getAccountByAccounttype(int Accounttype){
		ArrayList<Account> acc_list = new ArrayList<Account>();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Account where account_type="+Accounttype+";";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				Account acc = new Account();
				//Retrieve by column name
				String AccountId = rs.getString("acc_id");
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
	
	public void addAccount(Account account){
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "insert into account(acc_id,email,password,fname,minit," +
					"lname,bdate,address,sex,account_type,admin_acc) "+
			"VALUES("+account.getAccountId()+","+account.getEmail()+","
					+account.getPassword()+","+account.getFname()+","
					+account.getMinit()+","+account.getLname()+","
					+account.getBdate()+","+account.getAddress()
					+","+account.getSex()+","+account.getAccounttype()+","
					+account.getAdminacc()+" );";
			stmt.executeUpdate(sql);

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record	
	}
	

	public void removeAccount(String AccountId){
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "delete from account where acc_id='"+AccountId
					+"';";
			stmt.executeUpdate(sql);
		
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record		
	}
	public ArrayList<Account> getAccountByAdmin(String admin_id){
		ArrayList<Account> acc_list = new ArrayList<Account>();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from account where admin_acc='"+admin_id+"';";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				Account acc = new Account();
				//Retrieve by column name
				String AccountId = rs.getString("acc_id");
				String Email = rs.getString("email");
				String Password = rs.getString("password");
				String Minit = rs.getString("minit");
				String Lname = rs.getString("lname");
				String Bdate = rs.getString("bdate");
				String Address = rs.getString("address");
				char Sex = rs.getString("sex").toCharArray()[0];
				int Account_type = rs.getInt("account_type");
				String Fname = rs.getString("fname");
				
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
				acc.setAdminacc(admin_id);
				
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
	
}
