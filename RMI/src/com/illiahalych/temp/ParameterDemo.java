package com.illiahalych.temp;

import java.rmi.Naming;

public class ParameterDemo {
    public static void main(String[] args){
        Container c = null;
        try {
            c = (Container) Naming.lookup("container");
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

        /*
         * Here follow three blocks of code
         * presenting different manners of argument passing.
         * We discuss them further in the lecture.
         */

        // passing by reference
        try {
            System.out.println("\t\tRemote object test: passing a reference");
            Element e1 = (Element)c.get();
            System.out.println("get the element e1: " + e1.getValue());
            e1.setValue("aLocalValue");
            System.out.println("local modification: " + e1.getValue());
            Element e2 = (Element)c.get();
            System.out.println("get it again as e2: " + e2.getValue());

            System.out.println("e1 == e2 is " + (e1 == e2));
            System.out.println("e1.equals(e2) is " + (e1.equals(e2)));
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

        // passing by value
        try {
            System.out.println("\t\tLocal object test: passing by value");
            LocalElement le1 = new LocalElement("aLocalElement");
            System.out.println("put into the container : " + le1.getValue());
            c.put(le1);
            le1.setValue("newValue");
            System.out.println("local modification : " + le1.getValue());
            LocalElement le2 = (LocalElement)c.get();
            System.out.println("retrieved from the container    : " + le2.getValue());
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

        // compound object
        try {
            System.out.println(
                    "\t\tCompound object test"
            );
            CompoundElement ce = new CompoundElement("aCompoundElement");
            System.out.println("put into the container : " + ce.getValue());
            c.put(ce);
            ce.setValue("newCompoundValue");
            System.out.println("local modification : " + ce.getValue());
            ce = (CompoundElement)c.get();
            System.out.println("retrieved from the container    : " + ce.getValue());
            System.exit(0);
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
