package com.java24hours.classc;

public class Modem{

    static int count;
    private int speed;

    public Modem(){
        count++;
        speed=100000;
    }
    public Modem(int initSpeed){
        count++;
        speed=initSpeed;
    }

    static int getCount(){
        return count;
    }

    public void displaySpeed() {
        System.out.println("Speed: "+speed);       
    }
    public void disconnect(){
        System.out.println("Disconnecting... done!\n");
    }

    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int setValue){
        if((setValue>=100000)&(setValue<=1000000)){
            speed=setValue;
        }else{
            System.out.println("Error:not between 10k and 100k");
            System.out.println("Current speed is "+speed);
        }
    }
}