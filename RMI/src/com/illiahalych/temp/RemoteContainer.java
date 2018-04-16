package com.illiahalych.temp;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteContainer
        extends UnicastRemoteObject
        implements Container {

    private Object element;

    public RemoteContainer() throws RemoteException {
        element = new RemoteElement("aRemoteElement");
    }

    public void put(Object o) throws RemoteException {
        element = o;
    }

    public Object get() throws RemoteException {
        return element;
    }

    public static void main(String[] args){
        try {
            RemoteContainer rc = new RemoteContainer();
            Naming.rebind("container", rc);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
