package spring_rmi.spring_rmi_host;

public class RmiServiceImpl implements RmiService {
    @Override
    public void printMessage(String s) {
        System.out.println(s);
    }
}
