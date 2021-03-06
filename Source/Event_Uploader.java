//package event_ticketing;

public class Event_Uploader extends Account{
	String organization_id;
	String organization_name;
	String event_manager_id;
	public Event_Uploader() 
	{
		event_manager_id = null;
		organization_id = null;
		organization_name = null;
	}
	public Event_Uploader (String event_manager_id, String org_id, String org_nm)
	{
		this.event_manager_id = event_manager_id;
		this.organization_id = org_id;
		this.organization_name = org_nm;
	}
	
	
	public String getEvent_manager_id()
	{
		return this.event_manager_id; 
	}
	public void setEvent_manager_id(String s)
	{
		this.event_manager_id = s; 
	}
	public String getOrganization_id()
	{
		return this.organization_id; 
	}
	public void setOrganization_id(String s)
	{
		this.organization_id = s; 
	}
	public String getOrganization_name()
	{
		return this.organization_name; 
	}
	public void setOrganization_name(String s)
	{
		this.organization_name = s; 
	}
	
	public void show_eventUploader(){
		super.print();
		System.out.println("Organization_id: " + this.organization_id  + " Organization_name: " + this.organization_name);
	}
};
