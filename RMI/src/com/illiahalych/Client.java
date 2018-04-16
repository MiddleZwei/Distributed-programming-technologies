package com.illiahalych;

import com.illiahalych.RequestResponse.AddRequest;
import com.illiahalych.RequestResponse.AddResponse;
import com.illiahalych.RequestResponse.IRequest;
import com.illiahalych.RequestResponse.IResponse;

import java.rmi.Naming;

public class Client {
    public static void main(String args[]){
        try{
            String[] arguments = {"30", "4", "4"};
            IRequest request = getRequest(arguments);

            //what's next, how to send it to the server?

//            IResponse response = new AddResponse();

            Adder stub=(Adder) Naming.lookup("rmi://localhost:5000/sonoo");
            System.out.println(stub.add(34,4));
        }catch(Exception e){}
    }

    public static IRequest getRequest(String[] arguments){
        try {
            IRequest request = null;
                     request = new AddRequest(arguments);
            return request;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
