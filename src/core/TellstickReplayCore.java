import java.io.*;
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
		int tdSensor( byte[] protocol, int protocolLength, byte[] model, int modelLength, IntByReference id,IntByReference dataTypes );
		int tdSensorValue(byte[] protocol, byte[] model, int id, int dataType, byte[] value, int valueLength, IntByReference timestamp);
		int tdGetNumberOfDevices();
		int tdGetDeviceId( int deviceId );
		char tdGetName( int deviceId );
		void tdReleaseString( char string );
	}
	
	public enum Methods{
		TELLSTICK_TURNON, TELLSTICK_TURNOFF, TELLSTICK_BELL
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
	
	private void checkDeviceFeatures( int id ){
		
	}
	
	private boolean DimDeviceById( int id ) {
		
		return false;
	}
	
	private boolean DimDeviceByGroup( String name ) {
		
		return false;
	}
	
	private boolean TurnDeviceOffById( int id ){
		
		return false;
	}
}
