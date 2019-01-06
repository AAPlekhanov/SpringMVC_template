package spring_soap;


import javax.jws.WebService;

@WebService(serviceName = "SoapService")
public interface SoapSercice {

    public void printMessage(String s);

}
