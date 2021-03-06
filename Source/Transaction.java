//package event_ticketing;


class Transaction {
	private String trans_id;
	private String bank_id;
	private String user_id;
	private int total_amount;
	private String trans_date;
	private String time;
	public Transaction()
	{
		trans_id=null;
		bank_id=null;
		user_id=null;
		total_amount=0;
		trans_date=null;
		time=null;
	}
	public Transaction(String trans_id, String user_id, String bank_id)
	{
		this.trans_id=trans_id;
		this.user_id=user_id;
		this.bank_id=bank_id;
		total_amount=0;
		trans_date=null;
		time=null;
	}
	public String getTransId()
	{
		return this.trans_id;
	}
	public String getBankId()
	{
		return this.bank_id;
	}
	public String getUserId()
	{
		return this.user_id;
	}
	public int getAmount()
	{
		return this.total_amount;
	}
	public String getTransDate()
	{
		return this.trans_date;
	}
	public String getTransTime()
	{
		return this.time;
	}
	public void setTransId(String id)
	{
		this.trans_id=id;
	}
	public void setBankId(String bank)
	{
		this.bank_id=bank;
	}
	public void setUserId(String user)
	{
		this.user_id=user;
	}
	public void setAmount(int amount)
	{
		this.total_amount=amount;
	}
	public void setTransDate(String date)
	{
		this.trans_date=date;
	}
	public void setTransTime(String time)
	{
		this.time=time;
	}
	public void showTransaction()
	{
		System.out.println("Trans_id: " + this.getTransId() +
				", user_id: " + this.getUserId() + ", bank_id: "
				+ this.getBankId() + ", Amount: " + this.getAmount()
				+ ", Date: " + this.getTransDate() + ", Time: " +
				this.getTransDate());
	}
}
