package com.illiahalych.temp;

public class LocalElement
        implements java.io.Serializable {

    private String value;

    public LocalElement(String val) {
        value = val;
    }

    public void setValue(String val) {
        value = val;
    }

    public String getValue() {
        return value;
    }
}
