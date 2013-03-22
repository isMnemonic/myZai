package Compiler.TellstickReplay;

/**
 * @author Per Fransman
 *
 */
public class TellstickDevice {
	private final int id;
	private String title;
	private String model;
	private String protocol;
	private TellstickActions[] supported;
	
	public TellstickDevice( int _id, String _title, String _protocol, String _model, TellstickActions[] _supported ) {
		this.id = _id;
		this.title = _title;
		this.protocol = _protocol;
		this.model = _model;
		this.supported = _supported;
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMode() {
		return model;
	}
	
	public String getProtocol() {
		return protocol;
	}
	
	public TellstickActions[] getSupported() {
		return supported;
	}
}