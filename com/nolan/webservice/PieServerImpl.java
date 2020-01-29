package com.nolan.webservice;

import javax.jws.WebService;

@WebService(endpointInterface = "com.nolan.webservice.PieServer")
public class PieServerImpl implements PieServer{

    @Override
    public PieFrame getPieFrame() {

        try{
            PieFrame pieFrame=new PieFrame(3);
            return pieFrame;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
    
}