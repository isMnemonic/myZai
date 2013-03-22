/**
 * 
 */
package Compiler.TellstickReplay.DatabaseConnector;

/**
 * 
 * @author Per Fransman
 *
 */
public class TellstickReplaySqlQuerys {
	
	/**
	 * SQL Query: Selects all devices found in database.
	 */
	private String sqlSelectAllDevices = "SELECT id, title, protocol, model, supported FROM cyxl_device ORDER BY id;";
	
	/**
	 * SQL Query: Select specific device based on 'id'.
	 */
	private String sqlSelectDeviceById ="SELECT id, title, protocol, model, supported FROM cyxl_device WHERE id={0};";
	
	/**
	 * SQL Query: Selects settings configured for Tellstick Replay.
	 */
	private String sqlSelectSystemInformation = "SELECT os, tellstick, offline, initiated FROM cyxl_system;";
	
	/**
	 * SQL Query: Selects all groups.
	 */
	private String sqlSelectAllGroups = "SELECT id, name, description FROM cyxl_group;";
	
	/**
	 * SQL Query: Selects all schedules.
	 */
	private String sqlSelectAllSchedules ="SELECT cyxl_device.id, cyxl_schedule.task, cyxl_action.action, cyxl_schedule.value FROM cyxl_schedule, cyxl_action, cyxl_device where cyxl_schedule.action_id = cyxl_action.id and cyxl_device.id = cyxl_schedule.object_id;";
	
	/**
	 * SQL Query: Selects all devices with its corresponding schedules.
	 */
	private String sqlSelectDeviceWithSchedule = "SELECT d.id, d.title, d.protocol, d.model, d.description, d.supported, s.task, s.value, a.action FROM cyxl_device AS d, cyxl_schedule AS s, cyxl_action AS a WHERE d.id = s.object_id AND s.action_id = a.id ORDER BY d.id;";

	/**
	 * @return the sqlSelectAllDevices
	 */
	public String getSqlSelectAllDevices() {
		return sqlSelectAllDevices;
	}

	/**
	 * @param sqlSelectAllDevices the sqlSelectAllDevices to set
	 */
	public void setSqlSelectAllDevices(String sqlSelectAllDevices) {
		this.sqlSelectAllDevices = sqlSelectAllDevices;
	}

	/**
	 * @return the sqlSelectDeviceById
	 */
	public String getSqlSelectDeviceById() {
		return sqlSelectDeviceById;
	}

	/**
	 * @param sqlSelectDeviceById the sqlSelectDeviceById to set
	 */
	public void setSqlSelectDeviceById(String sqlSelectDeviceById) {
		this.sqlSelectDeviceById = sqlSelectDeviceById;
	}

	/**
	 * @return the sqlSelectSystemInformation
	 */
	public String getSqlSelectSystemInformation() {
		return sqlSelectSystemInformation;
	}

	/**
	 * @param sqlSelectSystemInformation the sqlSelectSystemInformation to set
	 */
	public void setSqlSelectSystemInformation(String sqlSelectSystemInformation) {
		this.sqlSelectSystemInformation = sqlSelectSystemInformation;
	}

	/**
	 * @return the sqlSelectAllGroups
	 */
	public String getSqlSelectAllGroups() {
		return sqlSelectAllGroups;
	}

	/**
	 * @param sqlSelectAllGroups the sqlSelectAllGroups to set
	 */
	public void setSqlSelectAllGroups(String sqlSelectAllGroups) {
		this.sqlSelectAllGroups = sqlSelectAllGroups;
	}

	/**
	 * @return the sqlSelectAllSchedules
	 */
	public String getSqlSelectAllSchedules() {
		return sqlSelectAllSchedules;
	}

	/**
	 * @param sqlSelectAllSchedules the sqlSelectAllSchedules to set
	 */
	public void setSqlSelectAllSchedules(String sqlSelectAllSchedules) {
		this.sqlSelectAllSchedules = sqlSelectAllSchedules;
	}

	/**
	 * @return the sqlSelectDeviceWithSchedule
	 */
	public String getSqlSelectDeviceWithSchedule() {
		return sqlSelectDeviceWithSchedule;
	}

	/**
	 * @param sqlSelectDeviceWithSchedule the sqlSelectDeviceWithSchedule to set
	 */
	public void setSqlSelectDeviceWithSchedule(String sqlSelectDeviceWithSchedule) {
		this.sqlSelectDeviceWithSchedule = sqlSelectDeviceWithSchedule;
	}

	
	
	
}
