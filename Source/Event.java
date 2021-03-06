//package event_ticketing;

public class Event {
	
	String event_id;
	String event_name;
	String event_date;
	String mgr_id;
	String event_desc;
	String event_addr;
	String time;
	int ticket_price;
	int max_size;
	int avail_size;

	public Event() {
		event_id = "";
		event_name = "";
		event_date = "";
		time = "";
		mgr_id = "";
		event_desc = "";
		event_addr = "";
		ticket_price = -1;
		max_size = -1;
		avail_size = -1;
	}
	
	public Event(String name, String date, String t, String addr, int size, int cost, String desc, String event_mgr_id){
		event_id = "Event_9006";
		event_name = name;
		event_date = date;
		time = t;
		mgr_id = event_mgr_id;
		event_desc = desc;
		event_addr = addr;
		ticket_price = cost;
		max_size = size;
		avail_size = size;
	}
	
	public void setId(String id) { event_id = id;}
 	public void setName(String name){ event_name = name;}
	public void setDate(String date){ event_date = date;}
	public void setAddr(String addr){ event_addr = addr;}
	public void setPrice(int cost){ ticket_price = cost;}
	public void setCapacity(int size){ max_size = size;}
	public void setAvailableSeat(int avail) { avail_size = avail;}
	public void setDesc(String desc){ event_desc = desc;}
	public void setManagerId(String eve_mgr_id){ mgr_id = eve_mgr_id;}
	public void setEventId(String id) { event_id = id;}
	public void setTime(String t) { time = t;}
	
	public String getId() { return event_id;}
	public String getName() { return event_name;}
	public String getDate() { return event_date;}
	public String getAddr() { return event_addr;}
	public String getDesc() { return event_desc;}
	public int getPrice() { return ticket_price;}
	public int getCapacity() { return max_size;}
	public int getAvailableSeat() { return avail_size;}
	public String getManagerId() { return mgr_id;}
	public String getEventId() { return event_id;}
	public String getTime() { return time;}
	
	public void print(){
		System.out.print("Event Name: " + event_name); 
		System.out.print(" | Event Date: " + event_date);
		System.out.print(" | Event Description: " + event_desc);
		System.out.print(" | Event Ticket Price: " + ticket_price);
		System.out.print(" | Time: " + time);
		System.out.println(" | Tickets Available: " + avail_size);
	}
	
}
