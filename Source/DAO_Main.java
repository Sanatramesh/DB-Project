//package event_ticketing;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DAO_Main {
	
	
	public static void main (String args[])throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		boolean flag = true;
		while (flag){
			
			System.out.println("\tMain Menu");
			System.out.println("1. Bank");
			System.out.println("2. Account");
			System.out.println("Enter Your Choice");
			
			choice = Integer.parseInt(reader.readLine());
			
			switch (choice) {
				case 1: flag = false;
						bankCase(reader);
						break;
				case 2:	flag = false;
						logIn(reader);
						break;
				default : System.out.println("Wrong Option");
			}
		}
	}
	public static void bankCase(BufferedReader reader){
		System.out.println("Enter Bank ID:");
		String bank_id;
		Bank bank = null;
		ArrayList<Transaction> trans = null;
		DAO_Factory daoFactory = new DAO_Factory();
		try {
			bank_id = reader.readLine();
			daoFactory.activateConnection();
			Bank_DAO bdao = daoFactory.getBankDAO();
			TransactionDAO trdao = daoFactory.getTransactionDAO();
			bank = bdao.getBankById(bank_id);
			bank.showBankDetail();
			trans = trdao.getTransactionByBank(bank_id);
			if (trans == null)
				System.out.println("No Transactions Found");
			else
				for (int i=0;i< trans.size(); i++)
				{
					trans.get(i).showTransaction();
				}
			daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
		}catch (Exception e){
			daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
			System.out.println("Error");
		}
	}
	
	public static void logIn(BufferedReader reader){
		Account acc = null;
		String eid = null, pwd=null;
		DAO_Factory daoFactory = new DAO_Factory();
		try {
			daoFactory.activateConnection();
			AccountDAO adao = daoFactory.getAccountDAO();
			while (true){
				System.out.print("Email:");
				eid = reader.readLine();
				acc = adao.getAccountByEmail(eid);
				System.out.print("Password");
				pwd = reader.readLine();
				if (!acc.getPassword().equals(pwd)){
					System.out.println("Wrong email/password");
					continue;
				}
				//acc.print();
				break;
			}
			daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
			switch (acc.getAccounttype()){
				case 1: userCase(reader, acc, daoFactory); break;
				case 2: eventUploderCase(reader, acc, daoFactory); break;
				case 3: adminCase(reader, acc, daoFactory); break;
				default:break;
			}
			System.out.println("Logged out");
		}catch (Exception e){
			daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
			System.out.println("Error");
		}
	}
	
	public static void userCase(BufferedReader reader, Account acc,
			DAO_Factory daoFactory){
		System.out.println("Welcome "+acc.getFname());
		int choice = 0;
		try
		{
			daoFactory.activateConnection();
			while(choice!=3)
			{
				System.out.println("1.View event according to date");
				System.out.println("2.Book ticket");
				System.out.println("3.Logout");
				System.out.print("Enter your option: ");
				choice = Integer.parseInt(reader.readLine());
				switch(choice)
				{
					case 1: viewEvent(daoFactory, reader);break;
					case 2: bookTicket(daoFactory, reader, acc);break;
					case 3: break;
					default: System.out.println("Wrong choice"); break;
				}
				daoFactory.activateConnection();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public static void viewEvent(DAO_Factory daoFactory, BufferedReader reader)
	{
		ArrayList<Event> events = null;
		boolean flag = true;
		try
		{
			String name=null, date=null;
			int choice;
			EventDAO edao = daoFactory.getEventDAO();
			System.out.println("1. Search event by name");
			System.out.println("2. Search event by date");
			choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1: System.out.print("Enter name:");
					name = reader.readLine();
					events = edao.getEventByName(name);
					break;
			case 2: System.out.print("Enter date(yyyy-mm-dd:");
					date = reader.readLine();
					events = edao.getEventByDate(date);
					break;
			default: System.out.println("Incorrect choice"); break;
			}
			for(int i=0; i<events.size(); i++)
				events.get(i).print();
			flag = true;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			flag = false;
		}
		finally{
			if (flag)
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
			else
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
		}
	}
	
	public static void bookTicket(DAO_Factory daoFactory,
			BufferedReader reader, Account acc)
	{
		boolean check = true;
		try
		{
			TransactionDAO trdao = daoFactory.getTransactionDAO();
			EventDAO edao = daoFactory.getEventDAO();
			TicketDAO tdao = daoFactory.getTicketDAO();
			String name = null, date = null, time = null;
			Event eve = null;
			boolean flag = false;
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date tDate = formatter.parse(formatter.format(new Date()));
			int num = 0;
			while(!flag && check)
			{
				System.out.print("Enter the name of the event: ");
				name = reader.readLine();
				System.out.print("Enter the date of the event(yyyy-mm-dd): ");
				date = reader.readLine();
				System.out.print("Enter the time of the event(HH:mm 24 hours): ");
				time = reader.readLine() + ":00";
				date += " " + time;
				if(tDate.after(formatter.parse(date)))
				{
					System.out.println("This date is before today's date");
					continue;
				}
				ArrayList<Event> events = edao.getEventByName(name);
				for(int i=0; i<events.size(); i++)
				{
					String testDate = events.get(i).getDate()
							+ " " + events.get(i).getTime();
					if(testDate.equals(date))
					{
						flag = true;
						eve = events.get(i);
						break;
					}
				}
				if(!flag)
				{
					System.out.println("Incorrect name,date/time pair");
					System.out.print("Do you want to cancel booking?(y/n)");
					char choice = reader.readLine().toLowerCase().toCharArray()[0];
					if(choice == 'y')
					{
						check = false;
						break;
					}
					continue;
				}
				if(eve.getAvailableSeat()==0)
				{
					System.out.println("No vacancy for the event!!!");
					flag = false;
					System.out.print("Do you want to book anything?(y/n)");
					char choice = reader.readLine().toLowerCase().toCharArray()[0];
					if(choice == 'n')
					{
						check = false;
						break;
					}
					continue;
				}
				while(check)
				{
					System.out.print("Enter the number of people attending: ");
					num = Integer.parseInt(reader.readLine());
					if(num<=eve.getAvailableSeat())
					{
						flag = true;
						break;
					}
					else
					{
						System.out.println("Vacancy only for " 
								+ eve.getAvailableSeat());
						System.out.print("Do you want to book anything?(y/n)");
						char choice = reader.readLine().toLowerCase().toCharArray()[0];
						if(choice == 'n')
						{
							check =  false;
							break;
						}
					}
				}
			}
			if(check)
			{
				String bank_id = "";
				System.out.print("Enter the bank_id: ");
				bank_id = reader.readLine();
				int totalPrice = num*eve.getPrice();
				int trans_num = trdao.getTotalTransaction();
				int ticket_num = tdao.getTotalTickets();
				String trans_id = Integer.toString(++trans_num);
				while(trans_id.length()<8)
					trans_id = "0" + trans_id;
				trans_id = "TR" + trans_id;
				Transaction tr = new Transaction(trans_id, acc.getAccountId(), bank_id);
				tr.setTransDate(formatter.format(tDate).split(" ")[0]);
				tr.setTransTime(formatter.format(tDate).split(" ")[1]);
				tr.setAmount(totalPrice);
				trdao.addTransaction(tr);
				for(int i=0; i<num; i++)
				{
					String ticket_id = Integer.toString(++ticket_num);
					while(ticket_id.length()<9)
						ticket_id = "0" + ticket_id;
					ticket_id = "T" + ticket_id;
					Ticket temp = new Ticket(ticket_id, eve.getId(), trans_id);
					temp.setCost(eve.getPrice());
					temp.setSeat_no(eve.getAvailableSeat()-1);
					eve.setAvailableSeat(eve.getAvailableSeat()-1);
					tdao.addTicket(temp);
				}
				edao.updateEvent(eve);
				Books_ForDAO bfdao = daoFactory.getBooks_ForDAO();
				bfdao.addUserEvent(acc.getAccountId(), eve.getId());
				check = true;
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			check = false;
		}
		finally{
			if (check)
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
			else
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
		}
	}
	
	public static void eventUploderCase(BufferedReader reader, Account acc,
			DAO_Factory daoFactory){
		int choice;
		try
		{
			daoFactory.activateConnection();
			Event_UploaderDAO eudao = daoFactory.getEventUploderDAO();
			Event_Uploader eu = eudao.getEvent_UploaderByMgrId(acc.getAccountId());
			eu.setAccountId(acc.getAccountId());
			eu.setEmail(acc.getEmail());
			eu.setPassword(acc.getPassword());
			eu.setFname(acc.getFname());
			eu.setMinit(acc.getMinit());
			eu.setLname(acc.getLname());
			eu.setBdate(acc.getBdate());
			eu.setAddress(acc.getAddress());
			eu.setSex(acc.getSex());
			eu.setAccounttype(acc.getAccounttype());
			eu.setAdminacc(acc.getAdminacc());
			eu.print();
			System.out.println("Welcome, Event Manager: " + eu.getFname());
			choice = 0;
			while (choice != 4){
				System.out.println("1. Add new Event");
				System.out.println("2. Update Event");
				System.out.println("3. View Events");
				System.out.println("4. Logout");
				System.out.println("Enter your option");
				choice = Integer.parseInt(reader.readLine());
				switch (choice) {
					case 1 : addNewEvent(daoFactory, eu.getEvent_manager_id(), reader);break;
					case 2 : UpdateEvent(daoFactory, eu.getEvent_manager_id(), reader);break;
					case 3 : ViewEvent(daoFactory, eu.getEvent_manager_id());break;
					case 4 : break;
					default : System.out.println("Invalid Option");
				}
				daoFactory.activateConnection();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public static void addNewEvent(DAO_Factory daoFactory, String mgr_id, BufferedReader reader){
		EventDAO edao = null;
		int dcnt = 0; //tcnt = 0;
		String date = null, time = null;
		int eve_no = -1;
		String id="E";
		boolean flag = false;
		try{
			Event eve = new Event();
			edao = daoFactory.getEventDAO();
			eve_no = edao.getTotalEvent();
			eve.setManagerId(mgr_id);
			System.out.print("Event Name: ");
			eve.setName(reader.readLine());
			System.out.print("Event Description: ");
			eve.setDesc(reader.readLine());
			System.out.print("Event Address: ");
			eve.setAddr(reader.readLine());
			System.out.print("Price: ");
			eve.setPrice(Integer.parseInt(reader.readLine()));
			System.out.print("Event Capacity: ");
			eve.setCapacity(Integer.parseInt(reader.readLine()));
			eve.setAvailableSeat(eve.getCapacity());
			System.out.print("Enter number of days: ");
			dcnt = Integer.parseInt(reader.readLine());
			for (int i=0;i<dcnt;i++){
				System.out.print("Event Date(yyyy-mm-dd): ");
				date = reader.readLine();
				eve.setDate(date);
				//for (int j=0;j<tcnt;j++){
				id = Integer.toString(++eve_no);;
				while(id.length()<9)
					id = "0" + id;;
				id = "E" + id;
				System.out.print("Time(HH:MM): ");
				time = reader.readLine()+":00";
				eve.setTime(time);
				eve.setId(id);
				edao.addEvent(eve);
					//eve_no++;
				//}
			}
			flag = true;
		}catch (Exception ex){
			System.out.println(ex.getMessage());
			flag = false;
		}
		finally{
			if (flag)
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
			else
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
		}
	}
	public static void UpdateEvent(DAO_Factory daoFactory,
			String mgr_id, BufferedReader reader){ 
		String name=null, date=null, time = null;
		ArrayList<Event> eve = null;
		Event e = null;
		boolean flag = false;
		boolean check = true;
		try{
			System.out.print("Enter Event Name:");
			name = reader.readLine();
			System.out.print("Enter date:");
			date = reader.readLine();
			System.out.print("Enter time:");
			time = reader.readLine()+":00";

			EventDAO edao = daoFactory.getEventDAO();
			eve = edao.getEventByMgrId(mgr_id);
			for (int i=0;i<eve.size();i++){
				e = eve.get(i);
				if (e.getName().equals(name) && e.getDate().equals(date)
						&& e.getTime().equals(time))
				{
					flag = true;
					break;
				}
			}
			if(!flag)
			{
				System.out.println("Invalid event name/date-time");
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
				return;
			}
			e.print();
			int choice = 0;
			int temp=0;
			String val=null;
			while (choice != 7 ){
				System.out.println("1. Change date");
				System.out.println("2. Change Time");
				System.out.println("3. Change Description");
				System.out.println("4. Change Address");
				System.out.println("5. Change Ticket Price");
				System.out.println("6. Change Capacity");
				System.out.println("7. Update Event");
				System.out.println("Enter your option:");
				choice = Integer.parseInt(reader.readLine());
				switch (choice) {
					case 1: System.out.println("Enter date:");
							val = reader.readLine();
							e.setDate(val);
							break;
					case 2: System.out.println("Enter time:");
							val = reader.readLine();
							e.setTime(val);
							break;
					case 3: System.out.println("Enter Description:");
							val = reader.readLine();
							e.setDesc(val);
							break;
					case 4: System.out.println("Enter Address:");
							val = reader.readLine();
							e.setAddr(val);
							break;
					case 5: System.out.println("Enter Ticket Price:");
							temp = Integer.parseInt(reader.readLine());
							e.setPrice(temp);
							break;
					case 6: System.out.println("Enter date:");
							temp = Integer.parseInt(reader.readLine());
							e.setCapacity(temp);
							e.setAvailableSeat(temp);
							break;
					case 7: edao.updateEvent(e); break;
					default : System.out.println("Invalid Option");
				}
			}
			check = true;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			check = false;
		}
		finally{
			if (check)
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
			else
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
		}
	}
	public static void ViewEvent(DAO_Factory daoFactory, String mgr_id){ 
		ArrayList<Event> eve = null;
		boolean flag=true;;
		try{
			EventDAO edao = daoFactory.getEventDAO();
			eve = edao.getEventByMgrId(mgr_id);
			for (int i=0;i<eve.size();i++)
				eve.get(i).print();
			flag = true;
		}catch (Exception e){
			System.out.println(e.getMessage());
			flag = false;
		}
		finally{
			if (flag)
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
			else
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
		}
	}
	
	public static void adminCase(BufferedReader reader, Account acc,
			DAO_Factory daoFactory){
		System.out.println("Welcome Admin "+acc.getFname());
		int choice = 0;
		try{
			daoFactory.activateConnection();
			while(choice !=3){
				System.out.println("1. View all Accounts");
				System.out.println("2. Delete an account");
				System.out.println("3. Logout");
				System.out.println("Enter Your Option");
				choice = Integer.parseInt(reader.readLine());
				switch (choice){
					case 1 : getAccount(acc, daoFactory);break;
					case 2 : deleteAccount(acc, reader, daoFactory);break;
					case 3 : break;
					default : System.out.println("Wrong Option");
				}
				daoFactory.activateConnection();
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void getAccount(Account acc, DAO_Factory daoFactory ){
		ArrayList<Account> accs = null;
		boolean flag = true;
		try{
			AccountDAO adao = daoFactory.getAccountDAO();
			accs = adao.getAccountByAdmin(acc.getAccountId());
			for (int i=0;i<accs.size();i++)
				accs.get(i).print();
			flag = true;
		}catch (Exception e){
			System.out.println(e.getMessage());
			flag = false;
		}
		finally{
			if (flag)
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
			else
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
		}
	}
	public static void deleteAccount(Account acc, BufferedReader reader, DAO_Factory daoFactory){
		String id;
		System.out.println("Enter User id to be Deleted");
		boolean flag = true;
		try{
			id = reader.readLine();
			AccountDAO adao = daoFactory.getAccountDAO();
			adao.removeAccount(id);
			flag = true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			flag = false;
		}
		finally{
			if (flag)
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.COMMIT);
			else
				daoFactory.deactivateConnection(DAO_Factory.TXN_STATUS.ROLLBACK);
		}
	}
}
