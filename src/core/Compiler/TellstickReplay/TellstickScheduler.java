package Compiler.TellstickReplay;

import Compiler.TellstickReplay.DatabaseConnector.DatabaseConnector;
import Compiler.TellstickReplay.DatabaseConnector.TellstickReplaySqlQuerys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
	
	
	/**
	 * 
	 */
	private Scheduler tellstickSchedule = null;
	private TellstickLibrary library = null;
	private DatabaseConnector database = null;
	private TellstickReplaySqlQuerys querys = null;
	
	/**
	 * Main constructor. Initiates a new Scheduler object with default configuration.
	 */
	public TellstickScheduler(TellstickLibrary library) {
		//This is the main way to initiate the scheduler. Modeling and scaling will be enabled
		//in the gui´s and they will be responseable for writing configuration files to check
		//if a Replay mode has been enabled/configured.
		
		this.querys = new TellstickReplaySqlQuerys();
		
		System.out.println("Creating new schedule.");							//TODO: Create seperate logging to file.
		Scheduler _scheduler = new Scheduler();
		this.library = library;
		System.out.println("Creating new tellstick device.");					//TODO: Create seperate logging to file.
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
		System.out.println("Setting schedule.");								//TODO: Create seperate logging to file.
		
		this.setTellstickSchedule(_scheduler);
		System.out.println("Initated TellstickScheduler();");					//TODO: Create seperate logging to file.
		this.setDatabase(new DatabaseConnector());
		System.out.println("Init db");											//TODO: Create seperate logging to file.
		
		try {
			Map<Object, ArrayList<String>> result = this.database.ExecuteQuery(this.querys.getSqlSelectAllSchedules(), TellstickActions.MANAGE_SCHEDULES);
			Set<Entry<Object, ArrayList<String>>> set = result.entrySet();
			Iterator<Entry<Object, ArrayList<String>>> iterate = set.iterator();
			while( iterate.hasNext()) {
				Map.Entry<Object, ArrayList<String>> me = (Map.Entry<Object, ArrayList<String>>)iterate.next();
				Integer row_id = (Integer)me.getKey();
				ArrayList<String> values = (ArrayList<String>)me.getValue();
				String task = null;
				TellstickActions action = null;
				String level = null;
				Integer count = 0;
				for(String value : values ){
					if(count == 0 ) {
						task = value;
					}else if(count == 1) {
						if( value == "DIM") {
							action = TellstickActions.DIM;
						}else if( value == "TURNON" ) {
							action = TellstickActions.TURNON;
						}else if( value == "TURNOFF" ){
							action = TellstickActions.TURNOFF;
						}
					}else if(count == 2) {
						level = value;
					}else {
						try {
							System.out.println("Setting new schedule.");
							_scheduler.schedule(task, new TellstickScheduleTask(this.library, new ActionEvent(this, action, device, new Byte(level))));
						} catch( RuntimeException rte ) {
							System.out.println("Eexception: " + rte.getMessage() );				//TODO: Create seperate logging to file.
						} catch( Exception e ) {
							System.out.println("Undefined exception.\r\n" + e.getMessage() );	//TODO: Create seperate logging to file.
						}
					}
					count++;
				}
			}
		} catch( Exception e ){
			System.out.println("Loaded schedules from db");						//TODO: Create seperate logging to file.
		} finally {
			System.out.println("Starting schedule.");							//TODO: Create seperate logging to file.
			_scheduler.start();
		}
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

	/**
	 * @return the querys
	 */
	public TellstickReplaySqlQuerys getQuerys() {
		return querys;
	}

	/**
	 * @param querys the querys to set
	 */
	public void setQuerys(TellstickReplaySqlQuerys querys) {
		this.querys = querys;
	}
	

}
