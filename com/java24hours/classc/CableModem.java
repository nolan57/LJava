package com.java24hours.classc;

public class CableModem extends Modem{
    String method  ="cable connection";
    public void conect(){
        System.out.println("Connecting to the internet ...");
        System.out.println("Using a "+method);
    }
}