/**
 * 
 */
package Compiler.TellstickReplay;

/**
 * @author Par
 *
 */
public class TellstickScheduleTask extends TellstickScheduleRunnable {
	
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(TellstickMethods method, TellstickDevice device) {
		// TODO Auto-generated method stub
		
	}

}
