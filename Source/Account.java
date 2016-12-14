//package event_ticketing;

public class Account {
	String AccountId;
	String email;
	String password;
	String fname;
	String minit;
	String lname;
	String bdate;
	String address;
	char sex;
	int account_type;
	String admin_acc;
	
	public Account()
	{
		 AccountId = "";
		 email = "";
		 password = "";
		 fname = "";
		 minit = "";
		 lname = "";
		 bdate = "";
		 address = "";
		 sex = 'M';
		 account_type = -1;
		 admin_acc = null;
	
	}
	
	public Account(String Email,String Password,String Fname,String Minit,
			String Lname,String Bdate,String Address,char Sex,
			int Account_type,String Admin_account)
	{
		 AccountId = "1000";
		 email = Email;
		 password = Password;
		 fname = Fname;
		 minit = Minit;
		 lname = Lname;
		 bdate = Bdate;
		 address = Address;
		 sex = Sex;
		 account_type = Account_type;
		 admin_acc = Admin_account;
	
	}
	
	
	public String getAccountId() { return AccountId; }
	public void setAccountId(String s){ AccountId = s; }
	
	public String getEmail() { return email; }
	public void setEmail(String s){ email = s; }
	
	public String getPassword() { return password; }
	public void setPassword(String s){ password = s; }
	
	public String getFname() { return fname; }
	public void setFname(String s){ fname = s; }
	
	public String getMinit() { return minit; }
	public void setMinit(String s){ minit = s; }
	
	public String getLname() { return lname; }
	public void setLname(String s){ lname = s; }
	
	public String getBdate() { return bdate; }
	public void setBdate(String s){ bdate = s; }
	
	public String getAddress() { return address; }
	public void setAddress(String s){ address = s; }
	
	public char getSex() { return sex; }
	public void setSex(char s){ sex = s; }
	
	public int getAccounttype() { return account_type; }
	public void setAccounttype(int s){ account_type = s; }
	
	public String getAdminacc(){return admin_acc;}
	public void setAdminacc(String s){admin_acc = s;}
	
	public void print()
	{
		System.out.print(" | Name: " + fname +" "+ minit + " " + lname);
		System.out.print(" | Account Id: " + AccountId);
		System.out.print(" | Account email: " + email);
		System.out.println(" | Birth date: " + bdate);
	
	}
}
