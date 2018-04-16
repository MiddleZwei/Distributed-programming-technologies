package com.illiahalych.temp;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Element extends Remote {

    void setValue(String str) throws RemoteException;

    String getValue() throws RemoteException;
}
