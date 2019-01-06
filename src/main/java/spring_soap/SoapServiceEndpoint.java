package spring_soap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
