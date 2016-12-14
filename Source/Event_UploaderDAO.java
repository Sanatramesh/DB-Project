//package event_ticketing;
import java.util.*;


public interface Event_UploaderDAO {

	public ArrayList<Event_Uploader> getEvent_UploaderByOrgId(String org_id);	
	public ArrayList<Event_Uploader> getEvent_UploaderByOrgName(String org_name);
	public Event_Uploader getEvent_UploaderByMgrId(String event_manager_id);
	
	public Event_Uploader getAccountByEvent_Uploader(Event_Uploader uploader);
	public boolean addEvent_Uploader(Event_Uploader uploader);
	public boolean deleteEvent_Uploader(String org_id);
	
}
