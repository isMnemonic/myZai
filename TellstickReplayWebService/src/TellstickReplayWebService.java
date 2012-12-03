import it.sauronsoftware.cron4j.*;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class TellstickReplayWebService {

	public TellstickReplayWebService() {
		// TODO Auto-generated constructor stub
	}
	
	public enum SessionState {
		
	}
	
	@WebMethod()
	public String[] getAllDevices() {
		return new String[9];
	}
	
	@WebMethod()
	public String getDeviceById( int id ) {
		return new String();
	}
	
	@WebMethod()
	public void setDeviceById( Object[] data, int id ){
		//TODO
	}
	
	@WebMethod()
	public String getDeviceByName( String device ){
		return new String();
	}
	
	@WebMethod()
	public void setDeviceByName( Object[] data, String name ){
		//TODO
	}
	
	@WebMethod()
	public String[] getAllSensors() {
		return new String[9];
	}
	
	@WebMethod()
	public String getSensorById( int id ){
		return new String();
	}
	
	@WebMethod()
	public void setSensorById( Object[] data, int id ){
		//TODO
	}
	
	@WebMethod()
	public String getSensorByName( String sensor ) {
		return new String();
	}
	
	@WebMethod()
	public void setSensorByName( Object[] data, String name ){
		//TODO
	}
	
	@WebMethod()
	public String[] getAllGroups() {
		return new String[9];
	}
	
	@WebMethod()
	public String getGroupById( int id ) {
		return new String();
	}
	
	@WebMethod()
	public void setGroudById( Object[] data, int id ){
		//TODO
	}
	
	@WebMethod()
	public String getGroupByName( String group ) {
		return new String();
	}
	
	@WebMethod()
	public void setGroupByName( Object[] data, String name ){
		//TODO
	}
	
	@WebMethod()
	public Boolean getStatusFlagById( int id ) {
		return true;
	}
	
	@WebMethod()
	public void setStatusFlagById( Boolean value, int id ){
		//TODO
	}
	
	@WebMethod()
	public Boolean getStatusFlagByName( String name ) {
		return true;
	}
	
	@WebMethod()
	public void setStatusFlagByName( Boolean value, String name ){
		//TODO
	}
}