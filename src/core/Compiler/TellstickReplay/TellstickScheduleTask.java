/**
 * 
 */
package Compiler.TellstickReplay;

import Compiler.TellstickReplay.TellstickActions;
import it.sauronsoftware.cron4j.*;

/**
 * @author Par
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
		case DIM:
			System.out.println("Executing Tellstick action: Dim");
			this.library.tdInit();
			this.library.tdDim(this.device.getId(), (Byte)this.event.getValue());
			this.library.tdClose();
			break;
		case TURNOFF:
			System.out.println("Executing Tellstick action: Turn off.");
			this.library.tdInit();
			this.library.tdTurnOff(this.device.getId());
			this.library.tdClose();
			System.out.println("Device turned off.");
			break;
		case TURNON:
			System.out.println("Executing Tellstick action: Turn on");
			this.library.tdInit();
			this.library.tdTurnOn(this.device.getId());
			this.library.tdClose();
			break;
		default:
			break;
			
		}
	}
	
	/**
	 * Devired constructor. Takes a 'CLibrary' parameter for access to the initated Telldus API.
	 * @param _clibrary
	 */
	public TellstickScheduleTask(TellstickLibrary _clibrary) {
		this.setTellstickLibrary(_clibrary);
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
