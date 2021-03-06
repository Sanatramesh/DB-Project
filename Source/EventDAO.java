//package event_ticketing;
import java.util.ArrayList;

public interface EventDAO {
	
	public Event getEventById(String id);
	public ArrayList<Event> getEventByName(String name);
	public ArrayList<Event> getEventByDate(String date);
	public ArrayList<Event> getEventByMgrId(String eve_mgr_id);
	
	public int getTotalEvent();
	public void addEvent(Event event);
	public void updateEvent(Event event);
	public void removeEvent(Event event);	
}
