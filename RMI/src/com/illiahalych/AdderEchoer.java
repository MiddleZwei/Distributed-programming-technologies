package com.illiahalych;

import com.illiahalych.RequestResponse.AddRequest;
import com.illiahalych.RequestResponse.AddResponse;
import com.illiahalych.RequestResponse.EchoRequest;
import com.illiahalych.RequestResponse.EchoResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdderEchoer extends Remote {
    AddResponse add(AddRequest ar)throws RemoteException;
    EchoResponse echo(EchoRequest echoRequest) throws RemoteException;
}
