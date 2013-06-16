/**
 * 
 */
package Compiler.TellstickReplay;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import Compiler.TellstickReplay.TellstickActions;
import it.sauronsoftware.cron4j.*;

/**
 * @author Per Fransman
 *
 */
@SuppressWarnings("unused")
public class TellstickScheduleTask extends Task {
	
	private TellstickLibrary library = null;
	private ActionEvent event = null;
	private TellstickDevice device = null;
	private boolean StatusActive = false;
	private Map<Object, ArrayList<String>> StatusInformation = null;
	
	/**
	 * Main constructor.
	 */
	public TellstickScheduleTask(TellstickLibrary library, ActionEvent event) {
		this.library = library;
		this.event = event;
		this.device = event.getDevice();
	}
	
	/**
	 * Overridden 'execute'. Handles all schedule tasks based actions.
	 */
	@Override
	public void execute(TaskExecutionContext arg0) throws RuntimeException {
		switch(this.event.getTellstickAction()){
		case DIM:
			if(!StatusActive){
				if(!DimDeviceById(this.device.getId(), (Byte)this.event.getValue())) {
					System.out.println("Device was not dimmed.");
				}
			}else {
				
			}
			break;
		case TURNOFF:
			if(!StatusActive){
				if(!TurnDeviceOffById(this.device.getId())) {
					System.out.println("Device was not turned off.");
				}
			}else {
				
			}
			break;
		case TURNON:
			if(!StatusActive) {
				if( !TurnDeviceOnById(this.device.getId()) ) {
					System.out.println("Device was not turned on.");
				}
			}else {
				
			}
			break;
		default:
			break;
		}
	}
	
	/**
	 * Description: Method 'DimDeviceById' dims the device with the supplied level.
	 * @param id
	 * @param level
	 * @return 'boolean' value of 'true' if the device was succesfully dimmed to the applied level or
	 * 'false' if it was unable to dim the device.
	 */
	private boolean DimDeviceById( int id, byte level ) {
		boolean value = false;
		try {
			System.out.println("Executing Tellstick action: Dim");
			this.library.tdInit();
			this.library.tdDim(id , level);
			this.library.tdClose();
			value = true;
		}
		catch( Exception e ){
			value = false;
			//throw e;
			System.out.println( e );
		}
		return value;
	}
	
	/**
	 * Description: Method 'DimDeviceByGroup' dims all devices in the group and by the supplied level.
	 * @param name
	 * @param level
	 * @return 'boolean' value of 'true' if the group was succesfully dimmed to the applied level or
	 * 'false' if it was unable to dim the group.
	 */
	private boolean DimDeviceByGroup( String name, int level ) {
		boolean value = false;
		try {
			
			value = true;
		}
		catch( Exception e ){
			value = false;
			//throw e;
			System.out.println( e );
		}
		return value;
	}
	
	/**
	 * Description: Method 'TurnDeviceOffById' uses the device id to access to turn it off.  
	 * @param id: Parameter 'id' is the device id of type 'int'.
	 * @return: 'boolean' value of 'true' if the device was successfully turned off or 
	 * 'false' if it was unable to turn the device off.
	 */
	private boolean TurnDeviceOffById( int id ){
		boolean value = false;
		try {
			System.out.println("Executing Tellstick action: Turn off.");
			this.library.tdInit();
			this.library.tdTurnOff( id );
			this.library.tdClose();
			System.out.println("Device: " + id + "has been turned off.");
			value = true;
		}
		catch( Exception e ){
			value = false;
			//throw e;
			System.out.println( e );
		}
		return value;
	}
	
	/**
	 * Description: 'TurnDeviceOnById'. Turns on a device by specifying its internal ID.
	 * @param id The device ID to used for identifing correct device.
	 * @return A 'boolean' value will be return 'true' for being turned on and 'false' for failure.
	 */
	private boolean TurnDeviceOnById( int id ){
		boolean value = false;
		try {
			System.out.println("Executing Tellstick action: Turn on");
			this.library.tdInit();
			this.library.tdTurnOn( id );
			this.library.tdClose();
			System.out.println("Device: " + id + "has been turned on.");
			value = true;
		}
		catch( Exception e ){
			value = false;
			//throw e;
			System.out.println( e );
		}
		return value;
	}
	
	private void getActiveStatusAction() {
		Set<Entry<Object, ArrayList<String>>> set = result1.entrySet();
		Iterator<Entry<Object, ArrayList<String>>> iterate = set.iterator();
		while( iterate.hasNext() ){
			Map.Entry<Object, ArrayList<String>> me = (Map.Entry<Object, ArrayList<String>>)iterate.next();
			ArrayList<String> values = (ArrayList<String>)me.getValue();
			Integer count = 0;
			for(String value : values){
				count++;
			}
		}
	}
	
	/**
	 * Devired constructor. Takes a 'CLibrary' parameter for access to the initated Telldus API.
	 * @param _clibrary
	 */
	public TellstickScheduleTask(TellstickLibrary library) {
		this.setTellstickLibrary(library);
	}

	/**
	 * Method: 'getTellstickLibrary' returns the local value of the type TellstickLibrary.
	 * @return: 'library' is a local stored value of the instance for the Telldus API C lib.
	 */
	public TellstickLibrary getTellstickibrary() {
		return library;
	}

	/**
	 * Method: 'setTellstickLibrary' stores the supplied value of type TellstickLibrary localy.
	 * @param 'library' is used to store a local value of the instance for the Telldus API C lib.
	 */
	public void setTellstickLibrary(TellstickLibrary library) {
		this.library = library;
	}
	
	/**
	 * Method: 'setStatusActive' stores the current state of status which will interupt schedules.
	 * @param 'value' is a boolean value.
	 */
	public void setStatusActive(boolean value) {
		this.StatusActive = value;
	}
	
	/**
	 * Method: 'setStatusInformation' stores the Map object holding the current active status information.
	 * @param 'StatusInformation' is Map<Object, ArrayList<String>> object.
	 */
	public void setStatusInformation( Map<Object, ArrayList<String>> StatusInformation ) {
		this.StatusInformation = StatusInformation;
	}

}
