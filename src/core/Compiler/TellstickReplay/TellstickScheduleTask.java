/**
 * 
 */
package Compiler.TellstickReplay;

import it.sauronsoftware.cron4j.*;

/**
 * @author Par
 *
 */
public class TellstickScheduleTask extends Task {
	
	private CLibrary _clibrary = null;
	
	/**
	 * Main constructor.
	 */
	public TellstickScheduleTask() {
		//TODO
	}
	
	/**
	 * Devired constructor. Takes a 'CLibrary' parameter for access to the initated Telldus API.
	 * @param _clibrary
	 */
	public TellstickScheduleTask(CLibrary _clibrary) {
		this.set_clibrary(_clibrary);
	}
	
	/**
	 * Execute. 
	 */
	@Override
	public void execute(TaskExecutionContext context) throws RuntimeException {
		
	}

	/**
	 * @return the _clibrary
	 */
	public CLibrary get_clibrary() {
		return _clibrary;
	}

	/**
	 * @param _clibrary the _clibrary to set
	 */
	public void set_clibrary(CLibrary _clibrary) {
		this._clibrary = _clibrary;
	}

}
