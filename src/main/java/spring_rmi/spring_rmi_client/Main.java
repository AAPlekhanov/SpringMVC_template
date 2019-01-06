package spring_rmi.spring_rmi_client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_rmi.spring_rmi_host.RmiService;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RmiClientConfig.class);
        RmiService rmiService = context.getBean(RmiService.class);
        rmiService.printMessage("hello RMI");
    }
}
