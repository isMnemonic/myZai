/**
 * 
 */
package Compiler.TellstickReplay;

import java.lang.Runnable;

/**
 * @author Per Fransman @  Compiler
 * Abstract class for 'TellstickScheduleRunnable'.
 */
public abstract class TellstickScheduleRunnable implements Runnable {

	public abstract void run(TellstickMethods method, TellstickDevice device); 
}