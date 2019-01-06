package spring_soap;

public class SoapServiceImpl implements SoapSercice {
    @Override
    public void printMessage(String s) {
        System.out.println(s);
    }
}
