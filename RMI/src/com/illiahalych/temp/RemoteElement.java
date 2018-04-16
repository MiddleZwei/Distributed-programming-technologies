package com.illiahalych.temp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteElement
        extends UnicastRemoteObject
        implements Element {

    private String value;

    public RemoteElement(String val) throws RemoteException {
        value = val;
    }

    public void setValue(String val) throws RemoteException {
        value = val;
    }

    public String getValue() throws RemoteException {
        return value;
    }
}
