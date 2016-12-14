//package event_ticketing;

import java.util.*;

public interface TransactionDAO {
	public Transaction getTransactionById(String trans_id);
	public ArrayList<Transaction> getTransactionByBank(String bank_id);
	public int getTotalTransaction();
	public Transaction performNewTransaction(String trans_id, 
			String user_id, String bank_id);
	public boolean addTransaction(Transaction transact);
	public boolean removeTransaction(String trans_id);
	public boolean removeTransactionForBank(String bank_id);
	public boolean removeTransactionByUser(String user_id);
}
