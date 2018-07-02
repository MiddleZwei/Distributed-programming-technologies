package eu.glowacki.tpo.composite;

public class CompositeRequest {

    public String _public;
    protected String _protected;
    String _packagePrivate;
    private String _private;
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