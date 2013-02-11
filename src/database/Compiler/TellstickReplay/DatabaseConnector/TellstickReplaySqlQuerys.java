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
	
	public static final String sqlSelectDeviceWithSchedule = "";
}
