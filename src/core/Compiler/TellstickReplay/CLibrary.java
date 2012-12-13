/**
 * 
 */
package Compiler.TellstickReplay;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

/**
 * @author Mnemonic
 *
 */
public interface CLibrary extends Library {
	void tdInit();
	void tdClose();
	int tdTurnOn( int deviceId );
	int tdTurnOff( int deviceId );
	int tdSensor( char protocol, int protocolLen, String model, int modelLen, int id, int dataTypes );
	int tdSensorValue( String protocol, String model, int id, int dataType, String value, int len, int timestamp );
	int tdController( int controllerId, int controllerType, char name, int nameLen, int available );
	int tdControllerValue( int controllerId, String name, String value, int valueLen );
	int tdSetControllerValue( int controllerId, String name, String value );
	int tdRemoveController( int controllerId );
	int tdGetNumberOfDevices();
	int tdGetDeviceId( int deviceId );
	int tdGetDeviceType( int deviceId );
	Pointer tdGetName( int deviceId );
	boolean tdSetName( int deviceId, String name );
	String tdGetProtocol( int deviceId );
	boolean tdSetProtocol( int deviceId, String protocol );
	String tdGetModel( int deviceId );
	boolean tdSetModel( int deviceId, String model );
	boolean tdSetDeviceParameter( int deviceId, String name, String value );
	String tdGetDeviceParameter( int deviceId, String name, String defaultValue );
	int tdAddDevice();
	boolean tdRemoveDevice( int deviceId );
	int tdMethods( int id, int methodsSupported );
	String tdGetErrorString( int errorNumber );
	int tdSendRawCommand( String command, int reserved );
	void tdSendRawCommand( int vid, int pid, String serial );
	void tdConnectTellstickController( int vid, int pid, String serial );
	void tdDisconnectTellstickController( int vid, int pid, String serial );				
	void tdReleaseString( Pointer value );
	int tdBell( int deviceId );
	int tdDim( int deviceId, byte level );
	int tdExecute( int deviceId );
	int tdUp( int deviceId );
	int tdDown( int deviceId );
	int tdStop( int deviceId );
	int tdLearn( int deviceId );
	int tdLastSentCommand( int deviceId, int methodSupported );
	Pointer tdLastSentValue( int deviceId );
}
