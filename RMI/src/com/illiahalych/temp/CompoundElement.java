package com.illiahalych.temp;

import java.io.Serializable;
import java.rmi.RemoteException;

public class CompoundElement
        implements Serializable {

    private LocalElement local;
    private Element remote;

    public CompoundElement(String val) {
        local = new LocalElement(val);
        try {
            remote = new RemoteElement(val);
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setValue(String val) {
        local.setValue(val);
        try {
            remote.setValue(val);
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getValue(){
        String retval = local.getValue() + "\t";
        try {
            retval += remote.getValue();
        }
        catch(RemoteException e){
            e.printStackTrace();
        }
        return retval;
    }
}
