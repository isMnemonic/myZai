package Compiler.TellstickReplay;

import Compiler.TellstickReplay.TellstickScheduleTask;

/**
 * @author Carlo Pelliccia
 * 
 */
import it.sauronsoftware.cron4j.Scheduler;

/**
 * @author Per Fransman
 *
 */
public class TellstickScheduler {
	private Scheduler tellstickSchedule = null;
	private TellstickLibrary library = null;
	
	/**
	 * Main constructor. Initiates a new Scheduler object with default configuration.
	 */
	public TellstickScheduler(TellstickLibrary library) {
		//This is the main way to initiate the scheduler. Modeling and scaling will be enabled
		//in the gui´s and they will be responseable for writing configuration files to check
		//if a Replay mode has been enabled/configured.
		System.out.println("Creating new schedule.");
		Scheduler _scheduler = new Scheduler();
		this.library = library;
		System.out.println("Creating new tellstick device.");
		TellstickDevice device = new TellstickDevice(
				2,
				"Nexa: Floorlamp: Left",
				"selflearning-dimmer:nexa",
				"arctech",
				new TellstickActions[]{
						TellstickActions.DIM,
						TellstickActions.DIMLEVEL,
						TellstickActions.TURNOFF,
						TellstickActions.TURNON
					});
		System.out.println("Setting schedule.");
		try {
			_scheduler.schedule("* * * * *", new TellstickScheduleTask(this.library, new ActionEvent(this, TellstickActions.TURNOFF, device, null)));
			_scheduler.start();
		} catch( RuntimeException rte ) {
			System.out.println("Eexception: " + rte.getMessage() );
		} catch( Exception e ) {
			System.out.println("Undefined exception.\r\n" + e.getMessage() );
		}
		System.out.println("Starting schedule.");
		this.setTellstickSchedule(_scheduler);
		System.out.println("Initated TellstickScheduler();");
		
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
	public TellstickLibrary getTelldusCore() {
		return this.library;
	}
	
	/**
	 * Method: 'setTellstickLibrary'. Set method for setting the mapped C library for the Tellstick API.
	 * @param: '_clibrary' to set in the private variable holder.
	 */
	public void setTellstickLibrary( TellstickLibrary library ) {
		this.library = library;
	}
	

}
