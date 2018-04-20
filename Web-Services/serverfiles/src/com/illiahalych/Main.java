package com.illiahalych;

import ws.CountryImpl;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args){
        try {
            Endpoint.publish("http://localhost:8080/ws/service", new CountryImpl());
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
