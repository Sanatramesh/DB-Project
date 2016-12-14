//package event_ticketing;

import java.util.ArrayList;

public interface Account_UserDAO{
	public ArrayList<Account_User> getAccountByName(String Fname);
	public Account_User getAccountById(String AccountId);
	public Account_User getAccountByEmail(String Email);
	public ArrayList<Account_User> getAccountByAccounttype(int Accounttype);
	
	public void addAccount(Account_User account);
	public void removeAccount(Account_User account);
	
}
