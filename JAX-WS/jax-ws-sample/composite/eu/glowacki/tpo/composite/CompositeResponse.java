package eu.glowacki.tpo.composite;

public class CompositeResponse {

    private String _private;
	
	String _packagePrivate;
	
	protected String _protected;
	
	public String _public;
	
	private String _readOnly;
	
	public String getPublic() {
		return _public;
	}
	
	public void setPublic(String p) {
		_public = p;
	}
	
	public String getReadOnly() {
		return _readOnly;
	}
}