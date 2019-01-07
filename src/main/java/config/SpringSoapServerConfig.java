package config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import spring_soap.spring_soap_service.SoapSercice;
import spring_soap.spring_soap_service.SoapServiceImpl;

@Configuration
public class SpringSoapServerConfig {

    @Bean
    public SoapSercice getSoapService() {
        return new SoapServiceImpl();
    }

    @Bean
    SimpleJaxWsServiceExporter exporter() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8889/");
        return exporter;
    }

}
