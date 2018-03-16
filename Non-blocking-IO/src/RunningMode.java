public enum RunningMode {

    WRITE("write", 1),
    READ("read", 0),
    EXIT("exit", -1);

    private final String _value;
    private final int _mark;

    RunningMode(String value, int mark) {
        _value = value;
        _mark = mark;
    }

    public static RunningMode getMode(String value){
            if (value.equalsIgnoreCase(WRITE.getValue())) return WRITE;
            else if (value.equalsIgnoreCase(READ.getValue())) return READ;
            else return EXIT;
    }

    public String getValue(){
        return _value;
    }

    public int getMark(){
        return _mark;
    }
}
