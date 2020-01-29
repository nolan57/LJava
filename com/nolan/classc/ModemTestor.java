package com.nolan.classc;

public class ModemTestor{
    public static void main(String[] args) {
        CableModem surfBoard = new CableModem();
        DslModem geteway = new DslModem();

        //surfBoard.speed = 500000;
        //geteway.speed = 400000;
        surfBoard.setSpeed(500000);
        //geteway.setSpeed(400000);
        geteway.setSpeed(5000);

        System.out.println("Trying the cable modem: ");
        surfBoard.displaySpeed();
        surfBoard.conect();
        surfBoard.disconnect();

        System.out.println("Trying the DSL modem: ");
        geteway.displaySpeed();
        geteway.connect();
        geteway.disconnect();

        System.out.println("The number of device created is :"+Modem.getCount());

        //float coutf=Modem.getCount();
        //Float coutF=Float.valueOf(fcout);
        
    }

}