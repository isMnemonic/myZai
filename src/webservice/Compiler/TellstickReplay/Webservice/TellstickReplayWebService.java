package Compiler.TellstickReplay.Webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Per Fransman
 *
 */
final class TokenHandler {
	private final String PUBLIC_KEY;
	private final String PRIVATE_KEY;
	private final String TOKEN;
	private final String TOKEN_SECRET;
	
	/**
	 * Description: Main constructor.
	 * @param Public_Key
	 * @param Private_Key
	 * @param Token
	 * @param Token_Secret
	 */
	public TokenHandler( String Public_Key, String Private_Key, String Token, String Token_Secret) {
		this.PUBLIC_KEY = Public_Key;
		this.PRIVATE_KEY = Private_Key;
		this.TOKEN = Token;
		this.TOKEN_SECRET = Token_Secret;
	}

	/**
	 * 
	 * @return
	 */
	public String getPUBLIC_KEY() {
		return PUBLIC_KEY;
	}

	/**
	 * 
	 * @return
	 */
	public String getPRIVATE_KEY() {
		return PRIVATE_KEY;
	}

	/**
	 * 
	 * @return
	 */
	public String getTOKEN() {
		return TOKEN;
	}

	/**
	 * 
	 * @return
	 */
	public String getTOKEN_SECRET() {
		return TOKEN_SECRET;
	}
}

/**
 * @author Per Fransman
 *
 */
@WebService()
public class TellstickReplayWebService {
	
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
	public TellstickReplayWebService() {
		// TODO Auto-generated constructor stub
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