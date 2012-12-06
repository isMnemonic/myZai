import java.io.*;
import java.lang.invoke.ConstantCallSite;

import it.sauronsoftware.cron4j.*;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.*;

public class TellstickReplayCore {
	
	public interface CLibrary extends Library{
		void tdInit();
		void tdClose();
		int tdTurnOn( int deviceId );
		int tdTurnOff( int deviceId );
		int tdSensor( char protocol, int protocolLen, char model, int modelLen, int id, int dataTypes );
		int tdSensorValue( char protocol, char model, int id, int dataType, char value, int len, int timestamp );
		int tdController( int controllerId, int controllerType, char name, int nameLen, int available );
		int tdControllerValue( int controllerId, char name, char value, int valueLen );
		int tdSetControllerValue( int controllerId, char name, char value );
		int tdRemoveController( int controllerId );
		int tdGetNumberOfDevices();
		int tdGetDeviceId( int deviceId );
		int tdGetDeviceType( int deviceId );
		char tdGetName( int deviceId );
		boolean tdSetName( int deviceId, char name );
		char tdGetProtocol( int deviceId );
		boolean tdSetProtocol( int deviceId, char protocol );
		char tdGetModel( int deviceId );
		boolean tdSetModel( int deviceId, char model );
		boolean tdSetDeviceParameter( int deviceId, char name, char value );
		char tdGetDeviceParameter( int deviceId, char name, char defaultValue );
		int tdAddDevice();
		boolean tdRemoveDevice( int deviceId );
		int tdMethods( int id, int methodsSupported );
		char tdGetErrorString( int errorNumber );
		int tdSendRawCommand( char command, int reserved );
		void tdSendRawCommand( int vid, int pid, char serial );
		void tdConnectTellstickController( int vid, int pid, char serial );
		void tdDisconnectTellstickController( int vid, int pid, char serial );				
		void tdReleaseString( char string );
		int tdBell( int deviceId );
		int tdDim( int deviceId, char level );
		int tdExecute( int deviceId );
		int tdUp( int deviceId );
		int tdDown( int deviceId );
		int tdStop( int deviceId );
		int tdLearn( int deviceId );
		int tdLastSentCommand( int deviceId, int methodSupported );
		char tdLastSentValue( int deviceId );
		
	}
	
	public class TellstickDevice{
		private final int id;
		private final char name;
		private final char model;
		private final char protocol;
		
		private final Methods[] supported;
		
		public TellstickDevice( int _id, char _name, char _model, char _protocol, Methods[] _supported ) {
			this.id = _id;
			this.name = _name;
			this.model = _model;
			this.protocol = _protocol;
			this.supported = _supported;
		}
		
		public int getId() {
			return id;
		}

		public char getName() {
			return name;
		}
		
		public char getMode() {
			return model;
		}
		
		public char getProtocol() {
			return protocol;
		}

		public Methods[] getSupported() {
			return supported;
		}
	}
	
	public enum Methods{
		TELLSTICK_TURNON, TELLSTICK_TURNOFF, TELLSTICK_BELL, CheckDeviceFeatures, DimDeviceById, DimDeviceByGroup, TurnDeviceOffById
	}
	
	public static void main(String[] args) {
		CLibrary libTelldus = (CLibrary)Native.loadLibrary("libtelldus-core.so.2", CLibrary.class);
		
		libTelldus.tdInit(); 									//Initiate the telldus api.
		
		int nrOfDevices = libTelldus.tdGetNumberOfDevices();	//Test: list devices.
		for ( int i = 0; i < nrOfDevices; i++ ) {				//Initiate loop.
			int id = libTelldus.tdGetDeviceId( i );				//Retrives the unique id on current index.
			char name = libTelldus.tdGetName( id );				//Retrives the name of the device by unique id.
			System.out.println( name );							//Simple printline. To be removed.
			libTelldus.tdReleaseString( name );					//Release the resource in 'char name'
		}
		
		libTelldus.tdClose(); 									//Close the telldus api. Clean up is done inside 'libtelldus-core.so.2'
		
	}
	
	private boolean CheckDeviceFeatures( int id ){
		boolean value = false;
		try {
			value = true;
		}
		catch( Exception exp ){
			value = false;
		}
		return value;
	}
	
	private boolean DimDeviceById( int id ) {
		boolean value = false;
		try {
			value = true;
		}
		catch( Exception exp ){
			value = false;
		}
		return value;
	}
	
	private boolean DimDeviceByGroup( String name ) {
		boolean value = false;
		try {
			value = true;
		}
		catch( Exception exp ){
			value = false;
		}
		return value;
	}
	
	private boolean TurnDeviceOffById( int id ){
		boolean value = false;
		try {
			value = true;
		}
		catch( Exception exp ){
			value = false;
		}
		return value;
	}
}
