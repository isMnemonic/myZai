/**
 * 
 */
package Compiler.TellstickReplay.DatabaseConnector;

/**
 * 
 * @author Per Fransman
 *
 */
public interface TellstickReplaySqlQuerys {
	
	public static final String sqlTemplate = "";
	
	public static final String sqlSelectAllDevices = "SELECT id, title, protocol, model, supported FROM cyxl_device ORDER BY id;";
	public static final String sqlSelectDeviceById ="SELECT id, title, protocol, model, supported FROM cyxl_device WHERE id={0};";
	public static final String sqlSelectSystemInformation = "SELECT os, tellstick, offline, initiated FROM cyxl_system;";
	public static final String sqlSelectAllGroups = "SELECT id, name, description FROM cyxl_group;";
	public static final String sqlSelectAllSchedules ="SELECT id, task, action_id, object_id FROM cyxl_schedule;";
	
	/**
	 * SQL Query: Selects all devices with its corresponding schedules.
	 */
	public static final String sqlSelectDeviceWithSchedule = "SELECT d.id, d.title, d.protocol, d.model, d.description, d.supported, s.task, s.value, a.action FROM cyxl_device AS d, cyxl_schedule AS s, cyxl_action AS a WHERE d.id = s.object_id AND s.action_id = a.id ORDER BY d.id;";
}
