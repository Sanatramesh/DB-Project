//package event_ticketing;

import java.util.ArrayList;

public interface Bank_DAO {
	public Bank getBankById(String bank_id);
	public ArrayList<Bank> getBankByName(String bank_name);
	public ArrayList<Bank> getBankByAddress(String bank_address);
	
	public void getTransactionByBank(String bank_id);
	public void removeBank(Bank bank);
	public void addBank(Bank bank);
	public void showBanks(ArrayList<Bank> banks);
}
