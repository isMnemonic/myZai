package Compiler.TellstickReplay;

import Compiler.TellstickReplay.TellstickScheduleTask;
import Compiler.TellstickReplay.DatabaseConnector.DatabaseConnector;

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
	private DatabaseConnector database = null;
	
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
				3,
				"Nexa: Floorlamp: Left",
				"selflearning-dimmer:nexa",
				"arctech",
				"description",
				new TellstickActions[]{
						TellstickActions.DIM,
						TellstickActions.DIMLEVEL,
						TellstickActions.TURNOFF,
						TellstickActions.TURNON
					});
		System.out.println("Setting schedule.");
		
		try {
			_scheduler.schedule("27 22 * * 1-5", new TellstickScheduleTask(this.library, new ActionEvent(this, TellstickActions.DIM, device, new Byte("10"))));
			_scheduler.start();
			System.out.println("Starting schedule.");
		} catch( RuntimeException rte ) {
			System.out.println("Eexception: " + rte.getMessage() );
		} catch( Exception e ) {
			System.out.println("Undefined exception.\r\n" + e.getMessage() );
		}
		
		this.setTellstickSchedule(_scheduler);
		System.out.println("Initated TellstickScheduler();");
		this.setDatabase(new DatabaseConnector());
		System.out.println("Init db");
	}
	
	/**
	 * Divered constructor. Backup: Loads schedule configuration from file.
	 * @param load: (String). Relative filepath to backup schedule configuration file. Resides in the installation folder.
	 */
	public void TellstickSchedulerLoadFromFile( String loadFile ){
		//TODO
	}
	
	/**
	 * Divered constructor. Reads schedule configuration from database
	 * @param connecToComputer: (String). IP adress or hostname.
	 * @param database: (String). Name of the database.
	 * @param user: (String). Database user name.
	 * @param password: (String). Database user password.
	 */
	public void TellstickSchedulerLoadFromDatabase( String connectToComputer, String database, String user, String password ) {
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

	/**
	 * @return the database
	 */
	public DatabaseConnector getDatabase() {
		return database;
	}

	/**
	 * @param database the database to set
	 */
	public void setDatabase(DatabaseConnector database) {
		this.database = database;
	}
	

}
