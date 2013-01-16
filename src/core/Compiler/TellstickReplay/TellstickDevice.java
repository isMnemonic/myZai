package Compiler.TellstickReplay;

/**
 * @author Per Fransman
 *
 */
public class TellstickDevice {
	private final int id;
	private final String name;
	private final String model;
	private final String protocol;
	
	private final TellstickMethods[] supported;
	
	public TellstickDevice( int _id, String _name, String _model, String _protocol, TellstickMethods[] _supported ) {
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

	public TellstickMethods[] getSupported() {
		return supported;
	}
}