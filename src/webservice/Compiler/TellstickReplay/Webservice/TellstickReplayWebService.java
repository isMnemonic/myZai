package Compiler.TellstickReplay.Webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import Compiler.TellstickReplay.TellstickActions;
import Compiler.TellstickReplay.TellstickLibrary;

/**
 * @author Per Fransman
 *
 */
@WebService()
public class TellstickReplayWebService {
	
	private TellstickLibrary library = null;
	
	/**
	 * 
	 * @author Per Fransman
	 *
	 */
	public enum TokenTypes {
		PUBLIC_KEY, PRIVATE_KEY, TOKEN, TOKEN_SECRET
	}

	/**
	 * Description: Main constructor.
	 */
	public TellstickReplayWebService(TellstickLibrary library) {
		this.library = library;
	}
	
	/**
	 * Description: External resources whom wants to send in commands.
	 * @param command
	 */
	public void SendCommand(TellstickActions tellstickaction) {
		switch(tellstickaction) {
		case START_WATCHING_MOVIE:
			break;
		case PAUSE_WATCHING_MOVIE:
			break;
		case STOPPED_WATCHING_MOVIE:
			break;
		default:
			break;
		}
	}
	
	/**
	 * Description: Method 'DimDeviceById'.
	 * @param id
	 * @param level
	 */
	@WebMethod()
	public void DimDeviceById(int id, byte level) {
		this.library.tdInit();
			
		this.library.tdClose();
	}
	
	/**
	 * Description: Method 'TurnOffLampsById'.
	 * @param 'id' of type int[].
	 */
	@WebMethod()
	public void TurnOffLampsById(int[] id) {
		this.library.tdInit();
		
		this.library.tdClose();
	}
	
	/**
	 * Description: Method 'getAllDevices' 
	 * @return String[] contains all devices found in the configuration.
	 */
	@WebMethod()
	public String[] getAllDevices() {
		return new String[9];
	}
	
	/**
	 * Description: Method 'getDeviceById'
	 * @param id
	 * @return
	 */
	@WebMethod()
	public String getDeviceById( int id ) {
		return new String();
	}
	
	/**
	 * Description: Method 'setDeviceById' 
	 * @param data
	 * @param id
	 */
	@WebMethod()
	public void setDeviceById( Object[] data, int id ){
		//TODO
	}
	
	/**
	 * Description: Method 'getDeviceByName'
	 * @param device
	 * @return
	 */
	@WebMethod()
	public String getDeviceByName( String device ){
		return new String();
	}
	
	/**
	 * Description: Method 'setDeviceByName'
	 * @param data
	 * @param name
	 */
	@WebMethod()
	public void setDeviceByName( Object[] data, String name ){
		//TODO
	}
	
	/**
	 * Description: Method 'getAllSensors'
	 * @return
	 */
	@WebMethod()
	public String[] getAllSensors() {
		return new String[9];
	}
	
	/**
	 * Description: Method 'getSensorById'
	 * @param id
	 * @return
	 */
	@WebMethod()
	public String getSensorById( int id ){
		return new String();
	}
	
	/**
	 * Description: Method 'setSensorById'
	 * @param data
	 * @param id
	 */
	@WebMethod()
	public void setSensorById( Object[] data, int id ){
		//TODO
	}
	
	/**
	 * Description: Method 'getSensorByName'
	 * @param sensor
	 * @return
	 */
	@WebMethod()
	public String getSensorByName( String sensor ) {
		return new String();
	}
	
	/**
	 * Description: Method 'setSensorByName'
	 * @param data
	 * @param name
	 */
	@WebMethod()
	public void setSensorByName( Object[] data, String name ){
		//TODO
	}
	
	/**
	 * Description: Method 'getAllGroups'
	 * @return
	 */
	@WebMethod()
	public String[] getAllGroups() {
		return new String[9];
	}
	
	/**
	 * Description: Method 'getGroupById'
	 * @param id
	 * @return
	 */
	@WebMethod()
	public String getGroupById( int id ) {
		return new String();
	}
	
	/**
	 * Description: Method 'setGroupById'
	 * @param data
	 * @param id
	 */
	@WebMethod()
	public void setGroudById( Object[] data, int id ){
		//TODO
	}
	
	/**
	 * Description: Method 'getGroupByName'
	 * @param group
	 * @return
	 */
	@WebMethod()
	public String getGroupByName( String group ) {
		return new String();
	}
	
	/**
	 * Description: Method 'setGroupByName'
	 * @param data
	 * @param name
	 */
	@WebMethod()
	public void setGroupByName( Object[] data, String name ){
		//TODO
	}
	
	/**
	 * Description: Method 'getStatusFlagById'
	 * @param id
	 * @return
	 */
	@WebMethod()
	public Boolean getStatusFlagById( int id ) {
		return true;
	}
	
	/**
	 * Description: Method 'setStatusFlagById'
	 * @param value
	 * @param id
	 */
	@WebMethod()
	public void setStatusFlagById( Boolean value, int id ){
		//TODO
	}
	
	/**
	 * Description: Method 'getStatusFlagByName'
	 * @param name
	 * @return
	 */
	@WebMethod()
	public Boolean getStatusFlagByName( String name ) {
		return true;
	}
	
	/**
	 * Description: Method 'setStatusFlagByName'
	 * @param value
	 * @param name
	 */
	@WebMethod()
	public void setStatusFlagByName( Boolean value, String name ){
		//TODO
	}
}