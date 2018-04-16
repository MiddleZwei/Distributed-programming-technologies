package com.illiahalych.temp;

import java.rmi.RemoteException;

public interface Container {
    void put(Object o) throws RemoteException;

    Object get() throws RemoteException;
}
