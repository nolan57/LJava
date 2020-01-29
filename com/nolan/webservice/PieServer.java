package com.nolan.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.*;
import javax.jws.soap.SOAPBinding.*;

@WebService
@SOAPBinding(style=Style.RPC)
public interface PieServer{
    @WebMethod PieFrame getPieFrame();
}