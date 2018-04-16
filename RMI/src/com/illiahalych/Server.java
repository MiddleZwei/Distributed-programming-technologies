package com.illiahalych;

import java.rmi.Naming;

public class Server {
    public static void main(String args[]){
        try{
            Adder stub=new AdderRemote();
            Naming.rebind("rmi://localhost:5000/sonoo",stub);
        }catch(Exception e){System.out.println(e);}
    }

}
