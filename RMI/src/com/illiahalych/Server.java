package com.illiahalych;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String args[]){
        try{
            LocateRegistry.createRegistry(5000);
            AdderEchoer stub=new AdderEchoerRemote();
            Naming.rebind("rmi://localhost:5000/sonoo",stub);
        }catch(Exception e){System.out.println(e);}
    }

}
