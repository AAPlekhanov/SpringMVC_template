package spring_soap.spring_soap_service;

import spring_soap.spring_soap_service.SoapSercice;

public class SoapServiceImpl implements SoapSercice {
    @Override
    public void printMessage(String s) {
        System.out.println(s);
    }
}
