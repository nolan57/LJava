package com.nolan.webservice;

;
//import javax.jws.soap.SOAPBinding.*;

@WebService
@SOAPBinding(style=Style.RPC)
public interface PieServer{
    @WebMethod void getPieFrame();
}