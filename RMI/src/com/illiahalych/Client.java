package com.illiahalych;

import com.illiahalych.RequestResponse.AddRequest;
import com.illiahalych.RequestResponse.AddResponse;
import com.illiahalych.RequestResponse.EchoRequest;
import com.illiahalych.RequestResponse.EchoResponse;

import java.rmi.Naming;

public class Client {
    public static void main(String args[]){
        try{
            AddRequest addRequest = new AddRequest();
            addRequest._a = 34;
            addRequest._b = 4;

            EchoRequest echoRequest = new EchoRequest();
            echoRequest.words.add("Hello");
            echoRequest.words.add(",");
            echoRequest.words.add(" ");
            echoRequest.words.add("World");
            echoRequest.words.add("!");



            AdderEchoer stub=(AdderEchoer) Naming.lookup("rmi://localhost:5000/sonoo");

            AddResponse addResponse = stub.add(addRequest);
            EchoResponse echoResponse = stub.echo(echoRequest);

            System.out.println(addResponse._sum);
            System.out.println(echoResponse._message);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
