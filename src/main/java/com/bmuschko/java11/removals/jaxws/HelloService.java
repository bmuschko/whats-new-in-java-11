package com.bmuschko.java11.removals.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(name = "HelloService", targetNamespace = "http://my.webservice.com")
@SOAPBinding(style = Style.DOCUMENT)
public interface HelloService {
    @WebMethod
    String sayHello(String msg);
}