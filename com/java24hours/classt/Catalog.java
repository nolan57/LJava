package com.java24hours.classt;

import java.net.*;

public class Catalog{
    class HomePage{
        String owner;
        URL address;
        String category="none";

        public HomePage(String inOwner,String inAddress)throws MalformedURLException{
            owner=inOwner;
            address=new URL(inAddress);
        }
        public HomePage(String inOwner,String inAddress,String inCategory)throws MalformedURLException{
            this(inOwner, inAddress);
            category=inCategory;
        }
    }
    public Catalog(){
        Catalog.HomePage[] catalog=new Catalog.HomePage[3];
        try{
            catalog[0]=new HomePage("Mark Evanier", "http://wwww.newsfromme.com","comic books");
            catalog[1]=new HomePage("Jeff Rients", "Http://jriend.blogspot.com", "gaming");
            catalog[2]=new HomePage("Rogers cadenhead", "http://workbench.cadenhead.org", "programming");
            for(int idx=0;idx<catalog.length;idx++){
                System.out.println(catalog[idx].owner+":"+catalog[idx].address+","+catalog[idx].category);
            }
        }catch(MalformedURLException eMalformedURLException){
            System.out.println("Error: "+eMalformedURLException.getMessage());
        }
    }
    public static void main(String[] args) {
        new Catalog();
    }
}