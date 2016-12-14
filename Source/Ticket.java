//package event_ticketing;

class Ticket{
	String ticket_id;
	String event_id;
	String trans_id;
	int cost;
	int seat_no;
	public Ticket() {
		ticket_id = null;
		event_id = null;
		trans_id = null;
		cost = 0;
		seat_no = 0;
 	}
	public Ticket (String t,String e, String trans){
	 	this.ticket_id = t;
		this.event_id = e;
		this.trans_id = trans;
		cost = 0;
		seat_no = 0;
	}
	public String getTicket_id() { return this.ticket_id; }
	public void setTicket_id(String s){ this.ticket_id = s; }

	public String getEvent_id() { return this.event_id; }
	public void setEvent_id(String s){ this.event_id = s; }

	public String getTrans_id() { return this.trans_id; }
	public void setTrans_id(String s){ this.trans_id = s; }
	
	public int getCost() { return this.cost; }
	public void setCost(int s){ this.cost = s; }

	public int getSeat_no() { return this.seat_no; }
	public void setSeat_no(int s){ this.seat_no = s; }


	public void showTicket()
	{
	System.out.println("Ticket_id: " + this.ticket_id + " Event_id: " + this.event_id + " Transaction_id: " + this.trans_id + " Cost: " + this.cost + " Seat_no: " + this.seat_no);
	}
};
