package spring_soap.spring_soap_service;


import javax.jws.WebService;

@WebService(serviceName = "SoapService")
public interface SoapSercice {

    public void printMessage(String s);

}
