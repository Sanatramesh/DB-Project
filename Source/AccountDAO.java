//package event_ticketing;

import java.util.ArrayList;

public interface AccountDAO {
	public ArrayList<Account> getAccountByName(String Fname);
	public Account getAccountById(String AccountId);
	public Account getAccountByEmail(String Email);
	public ArrayList<Account> getAccountByAccounttype(int Accounttype);
	public ArrayList<Account> getAccountByAdmin(String admin_id);
	
	public void addAccount(Account account);
	public void removeAccount(String Acc_id);
	
}
