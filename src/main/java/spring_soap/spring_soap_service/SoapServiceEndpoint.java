package spring_soap.spring_soap_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring_soap.spring_soap_service.SoapSercice;

import javax.jws.WebService;

@WebService(serviceName = "SoapService")
@Component
public class SoapServiceEndpoint {

    @Autowired
    SoapSercice soapSercice;

    public void printMessage(String s) {
        soapSercice.printMessage(s);
    }
}
