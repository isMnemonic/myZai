package Compiler.TellstickReplay;

import it.sauronsoftware.cron4j.*;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.*;

public class Core {
	
	public interface CLibrary extends Library{
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
		int tdDim( int deviceId, String level );
		int tdExecute( int deviceId );
		int tdUp( int deviceId );
		int tdDown( int deviceId );
		int tdStop( int deviceId );
		int tdLearn( int deviceId );
		int tdLastSentCommand( int deviceId, int methodSupported );
		String tdLastSentValue( int deviceId );
		
	}
	
	public class TellstickDevice{
		private final int id;
		private final String name;
		private final String model;
		private final String protocol;
		
		private final Methods[] supported;
		
		public TellstickDevice( int _id, String _name, String _model, String _protocol, Methods[] _supported ) {
			this.id = _id;
			this.name = _name;
			this.model = _model;
			this.protocol = _protocol;
			this.supported = _supported;
		}
		
		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}
		
		public String getMode() {
			return model;
		}
		
		public String getProtocol() {
			return protocol;
		}

		public Methods[] getSupported() {
			return supported;
		}
	}
	
	public enum Methods{
		TELLSTICK_TURNON, TELLSTICK_TURNOFF, TELLSTICK_BELL, CheckDeviceFeatures, DimDeviceById, DimDeviceByGroup, TurnDeviceOffById
	}
	
	public Core() { }
	
	public static void main(String[] args) {

		CLibrary libTelldus = (CLibrary)Native.loadLibrary("telldus-core", CLibrary.class);
		
		libTelldus.tdInit(); 										//Initiate the telldus api.
		
		int nrOfDevices = libTelldus.tdGetNumberOfDevices();		//Test: list devices.
		
		for ( int i = 0; i < nrOfDevices; i++ ) {					//Initiate loop.
			int id = libTelldus.tdGetDeviceId( i );					//Retrives the unique id on current index.
			System.out.println( id );
			Pointer pointerToName = libTelldus.tdGetName( id );		//Retrives the name of the device by unique id.
			String name = pointerToName.getString(0);
			//name = name.substring(0, name.indexOf(0));
			System.out.println( name );								//Simple printline. To be removed.
			String protocol = libTelldus.tdGetProtocol( id );
			System.out.println( protocol );
			String model = libTelldus.tdGetModel( id );
			System.out.println( model );
			Memory memory = new Memory( name.length());
			memory.write(0, name.getBytes(), 0, name.length());
			libTelldus.tdReleaseString( pointerToName );					//Release the resource in 'char name'
		}
		
		libTelldus.tdClose();
		
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
