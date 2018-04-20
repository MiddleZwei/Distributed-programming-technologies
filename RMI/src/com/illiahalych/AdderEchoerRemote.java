package com.illiahalych;

import com.illiahalych.RequestResponse.AddRequest;
import com.illiahalych.RequestResponse.AddResponse;
import com.illiahalych.RequestResponse.EchoRequest;
import com.illiahalych.RequestResponse.EchoResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdderEchoerRemote extends UnicastRemoteObject implements AdderEchoer {
    AdderEchoerRemote()throws RemoteException {
        super();
    }

    @Override
    public AddResponse add(AddRequest ar) throws RemoteException {

        AddResponse addResponse = new AddResponse();
        addResponse.setSum(ar.getA()+ar.getB());

        return addResponse;
    }

    @Override
    public EchoResponse echo(EchoRequest echoRequest) throws RemoteException{

        EchoResponse echoResponse = new EchoResponse();
        echoResponse.setMessage(echoRequest.getStatement());

        return echoResponse;
    }
}
