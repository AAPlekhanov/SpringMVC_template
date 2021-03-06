package spring_soap.spring_soap_client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_soap.spring_soap_service.SoapSercice;

public class TestSpringSoapService {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        SoapSercice bean = context.getBean(SoapSercice.class);
        bean.printMessage("test spring soap service");
    }
}
