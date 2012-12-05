import java.io.*;
import it.sauronsoftware.cron4j.*;
import com.sun.jna.*;
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
	}
	
	public static void main(String[] args) {
		CLibrary libTelldus = (CLibrary)Native.loadLibrary("libtelldus-core.so.2", CLibrary.class);
		
		libTelldus.tdInit(); //Initiate the telldus core.
		
		//Test: list devices.
		int nrOfDevices = libTelldus.tdGetNumberOfDevices();
		for ( int i = 0; i < nrOfDevices; i++ ) {
			int id = libTelldus.
		}
		
		libTelldus.tdClose(); //Close the telldus core. Clean up is done inside libtelldus-core.so.2
		
	}
}
