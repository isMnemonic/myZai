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
public class TellstickScheduler {
	private Scheduler TellstickSchedule;
	
	/**
	 * Main constructor. Initiates a new Scheduler object with default configuration.
	 */
	public TellstickScheduler() {
		//This is the main way to initiate the scheduler. Modeling and scaling will be enabled
		//in the gui´s and they will be responseable for writing configuration files to check
		//if a Replay mode has been enabled/configured.
		this.setTellstickSchedule(new Scheduler());
		System.out.println("Initiated scheduler.");
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
		return TellstickSchedule;
	}

	/**
	 * @param tellstickSchedule the tellstickSchedule to set
	 */
	public void setTellstickSchedule(Scheduler tellstickSchedule) {
		TellstickSchedule = tellstickSchedule;
	}
	

}
