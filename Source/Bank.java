//package event_ticketing;

class Bank {
	private String bank_id;
	private String bank_name;
	private String bank_address;
	public Bank()
	{
		bank_id = null;
		bank_name = null;
		bank_address = null;
	}
	
	public Bank(String bank_name, String bank_address)
	{
		this.bank_id = null;
		this.bank_name = bank_name;
		this.bank_address = bank_address;
	}
	
	public String getBank_id()
	{
		return this.bank_id;
	}
	
	public String getBank_name()
	{
		return this.bank_name;
	}
	
	public String getBank_address()
	{
		return this.bank_address;
	}
	
	public void setBank_id(String bank_id)
	{
		this.bank_id = bank_id;
	}
	
	public void setBank_name(String bank_name)
	{
		this.bank_name = bank_name;
	}

	public void setBank_address(String bank_address)
	{
		this.bank_address = bank_address;
	}
	
	public void showBankDetail()
	{
		System.out.print("Bank_id: " + this.bank_id);
		System.out.print(" | Bank_name: " + this.bank_name);
		System.out.print(" | Bank_Address: " + this.bank_address + "\n");
	}
}
