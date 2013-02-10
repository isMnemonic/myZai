/**
 * 
 */
package Compiler.TellstickReplay;

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
	
	/**
	 * Main constructor.
	 */
	public TellstickScheduleTask(TellstickLibrary library, ActionEvent event) {
		this.library = library;
		this.event = event;
		this.device = event.getDevice();
	}
	
	/**
	 * 
	 */
	@Override
	public void execute(TaskExecutionContext arg0) throws RuntimeException {
		switch(this.event.getTellstickAction()){
		case CHECK_DEVICE_FEATURES:
			
			break;
		case DIM:
			if(!DimDeviceById(this.device.getId(), (Byte)this.event.getValue())) {
				System.out.println("Device was not dimmed.");
			}
			break;
		case TURNOFF:
			if(!TurnDeviceOffById(this.device.getId())) {
				System.out.println("Device was not turned off.");
			}
			break;
		case TURNON:
			if( !TurnDeviceOnById(this.device.getId()) ) {
				System.out.println("Device was not turned on.");
			}
			break;
		default:
			break;
			
		}
	}
	
	/**
	 * Method: Method 'CheckDeviceFeatures' checks supplied device id for supported features.
	 * @param id
	 * @return 'boolean' value of 'true' if the supplied 'id' has the 
	 */
	public boolean CheckDeviceFeatures( int id ){
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
	 * Description: Method 'DimDeviceById' dims the device with the supplied level.
	 * @param id
	 * @param level
	 * @return 'boolean' value of 'true' if the device was succesfully dimmed to the applied level or
	 * 'false' if it was unable to dim the device.
	 */
	public boolean DimDeviceById( int id, byte level ) {
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
	public boolean DimDeviceByGroup( String name, int level ) {
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
	public boolean TurnDeviceOffById( int id ){
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
	public boolean TurnDeviceOnById( int id ){
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
	
	/**
	 * Devired constructor. Takes a 'CLibrary' parameter for access to the initated Telldus API.
	 * @param _clibrary
	 */
	public TellstickScheduleTask(TellstickLibrary library) {
		this.setTellstickLibrary(library);
	}

	/**
	 */
	public TellstickLibrary getTellstickibrary() {
		return library;
	}

	/**
	 * @param _clibrary the _clibrary to set
	 */
	public void setTellstickLibrary(TellstickLibrary library) {
		this.library = library;
	}

}
