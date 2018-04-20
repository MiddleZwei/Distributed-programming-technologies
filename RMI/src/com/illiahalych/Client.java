package com.illiahalych;

import com.illiahalych.RequestResponse.AddRequest;
import com.illiahalych.RequestResponse.AddResponse;
import com.illiahalych.RequestResponse.EchoRequest;
import com.illiahalych.RequestResponse.EchoResponse;

import java.rmi.Naming;

public class Client {
    public static void main(String args[]){
        try{

            // Create requests
            AddRequest addRequest = new AddRequest();
            addRequest.setA(34);
            addRequest.setB(4);

            EchoRequest echoRequest = new EchoRequest();
            echoRequest.setStatement("Hello, Client!");

            // Create a stub
            AdderEchoer stub=(AdderEchoer) Naming.lookup("rmi://localhost:5000/sonoo");

            // Get responses
            AddResponse addResponse = stub.add(addRequest);
            EchoResponse echoResponse = stub.echo(echoRequest);

            // Output the results
            System.out.println(addResponse.getSum());
            System.out.println(echoResponse.getMessage());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
