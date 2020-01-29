package com.nolan.webservice;

import javax.xml.ws.Endpoint;;

public class PieServerPublisher{
    public static void main(String[] args) {
        PieServerImpl pieServerImpl=new PieServerImpl();
        System.out.println("Right here!");
        try{
        Endpoint.publish(
            "http://127.0.0.1:5355/service",
            pieServerImpl
            );
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
