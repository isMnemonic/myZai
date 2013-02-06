package Compiler.TellstickReplay;

/**
 * @author Carlo Pelliccia
 * 
 */
import it.sauronsoftware.cron4j.*;

/**
 * @author Per Fransman
 * 
 */
import Compiler.TellstickReplay.CLibrary;

/**
 * @author Per Fransman
 *
 */
public class TellstickScheduler {
	private Scheduler tellstickSchedule = null;
	private TellstickScheduleTask task = null;
	private CLibrary libTelldusCore = null;
	
	/**
	 * Main constructor. Initiates a new Scheduler object with default configuration.
	 */
	public TellstickScheduler(CLibrary _clibrary) {
		//This is the main way to initiate the scheduler. Modeling and scaling will be enabled
		//in the gui´s and they will be responseable for writing configuration files to check
		//if a Replay mode has been enabled/configured.
		Scheduler _scheduler = new Scheduler();
		this.setTellstickLibrary(_clibrary);
		_scheduler.schedule("* * * * *", this.task);
		this.setTellstickSchedule(_scheduler);
	}
	
	/**
	 * Divered constructor. Backup: Loads schedule configuration from file.
	 * @param load: (String). Relative filepath to backup schedule configuration file. Resides in the installation folder.
	 */
	public TellstickScheduler( String loadFile ){
		//TODO
	}
	
	/**
	 * Divered constructor. Reads schedule configuration from database
	 * @param connecToComputer: (String). IP adress or hostname.
	 * @param database: (String). Name of the database.
	 * @param user: (String). Database user name.
	 * @param password: (String). Database user password.
	 */
	public TellstickScheduler( String connectToComputer, String database, String user, String password ) {
		//TODO
	}

	/**
	 * @return the tellstickSchedule
	 */
	public Scheduler getTellstickSchedule() {
		return this.tellstickSchedule;
	}

	/**
	 * @param tellstickSchedule the tellstickSchedule to set
	 */
	public void setTellstickSchedule(Scheduler tellstickSchedule) {
		this.tellstickSchedule = tellstickSchedule;
	}
	
	/**
	 * Method: 'getTelldusCore'. Get method for returning the mapped C library for the Tellstick API.
	 * @return: 'CLibrary' object which is an instance of the running Tellstick API.
	 */
	public CLibrary getTelldusCore() {
		return this.libTelldusCore;
	}
	
	/**
	 * Method: 'setTellstickLibrary'. Set method for setting the mapped C library for the Tellstick API.
	 * @param: '_clibrary' to set in the private variable holder.
	 */
	public void setTellstickLibrary( CLibrary _clibrary ) {
		this.libTelldusCore = _clibrary;
	}
	

}
