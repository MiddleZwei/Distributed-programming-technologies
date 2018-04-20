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
            addRequest._a = 34;
            addRequest._b = 4;

            EchoRequest echoRequest = new EchoRequest();
            echoRequest._statement = "Hello, Client!";

            // Create a stub
            AdderEchoer stub=(AdderEchoer) Naming.lookup("rmi://localhost:5000/sonoo");

            // Get responses
            AddResponse addResponse = stub.add(addRequest);
            EchoResponse echoResponse = stub.echo(echoRequest);

            // Output the results
            System.out.println(addResponse._sum);
            System.out.println(echoResponse._message);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
